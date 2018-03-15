package com.lauracarpaciu.entities.order;


import com.lauracarpaciu.entities.data.BaseEntity;
import com.lauracarpaciu.entities.product.Product;

import javax.persistence.*;
import java.io.Serializable;

public class LineItem  extends BaseEntity implements Serializable {
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
    }

    public LineItem(Long createdAt, Long lastModified, Product product, int quantity, double price, double tax, Order order) {
        super(createdAt, lastModified);
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.order = order;
    }
}
