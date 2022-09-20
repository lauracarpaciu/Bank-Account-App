package com.lauracarpaciu.entity.cart;

import com.lauracarpaciu.entity.data.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="cart_events",indexes = { @Index(name = "IDX_CART_EVENT_USER", columnList = "id,userId") })
public class CartEvent extends BaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CartEventType cartEventType;
    private Long userId;
    private String productId;
    private Integer quantity;

    public CartEvent() {
        super();
    }

    public CartEvent(Long createdAt, Long lastModified, CartEventType cartEventType, Long userId) {
        super(createdAt, lastModified);
        this.cartEventType = cartEventType;
        this.userId = userId;
    }

    public CartEvent(Long createdAt, Long lastModified, CartEventType cartEventType, Long userId, String productId, Integer quantity) {
        super(createdAt, lastModified);
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
