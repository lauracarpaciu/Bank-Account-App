package com.lauracarpaciu.controller;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.order.LineItem;
import com.lauracarpaciu.entities.order.Order;
import com.lauracarpaciu.entities.order.OrderEvent;
import com.lauracarpaciu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;


    public Order createOrder(List<LineItem> lineItems) {
        return orderService.createOrder(lineItems);
    }

    public Boolean addOrderEvent(OrderEvent orderEvent, Boolean validate) {
        return orderService.addOrderEvent(orderEvent, validate);
    }

    public List<Order> getOrdersForAccount(Account accountNumber) {
        return orderService.getOrdersForAccount(accountNumber);
    }

    public Order getOrder(String orderId, Boolean validate) {
        return orderService.getOrder(orderId, validate);
    }

    public boolean validateAccountNumber(String accountNumber) {
        return orderService.validateAccountNumber(accountNumber);
    }




}
