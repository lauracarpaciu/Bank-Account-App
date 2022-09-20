package com.lauracarpaciu.entity.cart;

import com.lauracarpaciu.entity.catalog.Category;
import reactor.core.publisher.Flux;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShoppingCart implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(String.valueOf(ShoppingCart.class));
    private Map<String, Integer> productMap = new HashMap<>();
    private Collection<LineItem> lineItems = new ArrayList<>();
    private Category category;

    public ShoppingCart(Category category) {
        this.category = category;
    }


    public Map<String, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Integer> productMap) {
        this.productMap = productMap;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public void setLineItems(Collection<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Collection<LineItem> getLineItems() throws Exception {
        lineItems = productMap.entrySet()
                .stream()
                .map(item -> new LineItem(item.getKey(), category.getProducts().stream()
                        .filter(prd -> Objects.equals(prd.getProductId(), item.getKey()))
                        .findFirst()
                        .orElse(null), item.getValue()))
                .filter(item -> item.getQuantity() > 0)
                .collect(Collectors.toList());

        if (lineItems.stream()
                .anyMatch(item -> item.getProduct() == null)) {
            throw new Exception("Product not found in category");
        }

        return lineItems;
    }

    public ShoppingCart add(CartEvent cartEvent) {
        Flux<CartEventType> validCartEventTypes =
                Flux.fromStream(Stream.of(CartEventType.ADD_ITEM,
                        CartEventType.REMOVE_ITEM));


        if (validCartEventTypes != null) {
            productMap.put(cartEvent.getProductId(),
                    productMap.getOrDefault(cartEvent.getProductId(), 0) +
                            (cartEvent.getQuantity() * (cartEvent.getCartEventType()
                                    .equals(CartEventType.ADD_ITEM) ? 1 : -1)));
        }


        return this;
    }

    public static Boolean isTerminal(CartEventType eventType) {
        return (eventType == CartEventType.CLEAR_CART || eventType == CartEventType.CHECKOUT);
    }

    public double getTotal() {

        double total = 0;
        for (LineItem lc : lineItems) {

            total += lc.getProduct().getUnitPrice() * lc.getQuantity();
        }
        return total;
    }

    public int getSize() {

        return lineItems.size();
    }


}
