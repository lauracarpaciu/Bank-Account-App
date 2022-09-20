package com.lauracarpaciu.entity.order;

import com.lauracarpaciu.entity.data.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderEvents")
public class OrderEvent extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String id;
    private OrderEventType type;
    private String orderId;

    public OrderEvent() {
    }

    public OrderEvent(Long createdAt, Long lastModified, OrderEventType type, String orderId) {
        super(createdAt, lastModified);
        this.type = type;
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderEventType getType() {
        return type;
    }

    public void setType(OrderEventType type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", orderId='" + orderId + '\'' +
                "} " + super.toString();
    }
}
