package com.lauracarpaciu.service.catalog;

import com.lauracarpaciu.entities.cart.ShoppingCart;
import com.lauracarpaciu.entities.catalog.Category;
import com.lauracarpaciu.entities.customer.Customer;
import com.lauracarpaciu.entities.order.Order;
import com.lauracarpaciu.entities.product.Product;

import java.util.List;

public interface ServiceInternet {
    List<Category> categoriesList();

    Category getCategory(Long idCat);

    List<Product> productslist();

    List<Product> productsbykeyname(String kn);

    List<Product> productsbyCategory(Long idCat);

    List<Product> selectedProducts();

    Product getProduct(Long idP);

    Order addOrder(ShoppingCart cart, Customer c);
}
