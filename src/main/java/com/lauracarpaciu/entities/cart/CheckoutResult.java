package com.lauracarpaciu.entities.cart;

import com.lauracarpaciu.entities.order.Order;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name="checkoutResult")
public class CheckoutResult implements Serializable{

    private String resultMessage;
    private Order order;

    public CheckoutResult() {
        super();
    }


    public CheckoutResult(String resultMessage, Order order) {
        this.resultMessage = resultMessage;
        this.order = order;
    }

    public CheckoutResult(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
