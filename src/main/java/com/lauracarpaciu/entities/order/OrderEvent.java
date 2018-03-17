package com.lauracarpaciu.entities.order;

import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name="orderEvens")
public class OrderEvent extends BaseEntity{
    @Id
    private String id;
    private OrderEventType type;
    private String orderId;

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

    public OrderEvent() {
    }

    public OrderEvent(Long createdAt, Long lastModified, OrderEventType type, String orderId) {
        super(createdAt, lastModified);
        this.type = type;
        this.orderId = orderId;
    }
}
