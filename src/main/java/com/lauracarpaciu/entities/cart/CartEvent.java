package com.lauracarpaciu.entities.cart;

import com.lauracarpaciu.entities.data.BaseEntity;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name="cart_events")
public class CartEvent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CartEventType cartEventType;
    private Long userId;
    private String productId;
    private Integer quantity;

    public CartEvent() {
        super();
    }

    public CartEvent(CartEventType cartEventType, Long userId) {
        this.cartEventType = cartEventType;
        this.userId = userId;
    }

    public CartEvent(CartEventType cartEventType, Long userId, String productId, Integer quantity) {
        this.cartEventType = cartEventType;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CartEventType getCartEventType() {
        return cartEventType;
    }

    public void setCartEventType(CartEventType cartEventType) {
        this.cartEventType = cartEventType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
