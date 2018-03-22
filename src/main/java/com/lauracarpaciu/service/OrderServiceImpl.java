package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.OrderEventRepository;
import com.lauracarpaciu.dao.OrderRepository;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.order.LineItem;
import com.lauracarpaciu.entities.order.Order;
import com.lauracarpaciu.entities.order.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderEventRepository orderEventRepository;


    @Override
    public Order createOrder(List<LineItem> lineItems) {
        return null;
    }

    @Override
    public Boolean addOrderEvent(OrderEvent orderEvent, Boolean validate) {
        return null;
    }

    @Override
    public List<Order> getOrdersForAccount(Account accountNumber) {
        return null;
    }

    @Override
    public Order getOrder(String orderId, Boolean validate) {
        return null;
    }

    @Override
    public boolean validateAccountNumber(String accountNumber) {
        return false;
    }
}
