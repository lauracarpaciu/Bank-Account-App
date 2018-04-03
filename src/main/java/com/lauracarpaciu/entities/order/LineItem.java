package com.lauracarpaciu.entities.order;


import com.lauracarpaciu.entities.data.BaseEntity;
import com.lauracarpaciu.entities.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "line_items")
public class LineItem  extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    private int quantity;
    private double price,tax;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    public LineItem(Long createdAt, Long lastModified, int quantity, double price, double tax) {
        super(createdAt, lastModified);
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
    }

    public LineItem() {
        super();
    }

    public LineItem(Long createdAt, Long lastModified, Product product, int quantity, double price, double tax, Order order) {
        super(createdAt, lastModified);
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
