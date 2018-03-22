package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.order.LineItem;
import com.lauracarpaciu.entities.order.Order;
import com.lauracarpaciu.entities.order.OrderEvent;

import java.util.List;

public interface OrderService {

    Order createOrder(List<LineItem> lineItems);

    Boolean addOrderEvent(OrderEvent orderEvent, Boolean validate);

    List<Order> getOrdersForAccount(Account accountNumber);

    Order getOrder(String orderId, Boolean validate);

    boolean validateAccountNumber(String accountNumber);
}
