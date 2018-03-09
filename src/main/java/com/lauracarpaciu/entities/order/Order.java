package com.lauracarpaciu.entities.order;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.address.Address;
import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "orderS")
    private Collection<LineItem> lineItems;
    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address shippingAddress;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Collection<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Collection<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Order() {
    }

}
