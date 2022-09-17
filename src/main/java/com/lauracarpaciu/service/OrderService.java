package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.order.LineItem;
import com.lauracarpaciu.entities.order.Order;
import com.lauracarpaciu.entities.order.OrderEvent;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface OrderService {

    Order createOrder(List<LineItem> lineItems);

    boolean addOrderEvent(OrderEvent orderEvent, Boolean validate, String orderId) throws Exception;

    List<Order> getOrdersForAccount(Account accountNumber);

    Order getOrder(String orderId, Boolean validate);

    boolean validateAccountNumber(Account accountNumber);
}
