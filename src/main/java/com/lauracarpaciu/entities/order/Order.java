package com.lauracarpaciu.entities.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.address.Address;
import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity  {
    @Id
    private String orderId;
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    private Collection<LineItem> lineItems;
    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address shippingAddress;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    @JsonIgnore
    @XmlTransient
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

    public Order(Long createdAt, Long lastModified) {
        super(createdAt, lastModified);
    }
}
