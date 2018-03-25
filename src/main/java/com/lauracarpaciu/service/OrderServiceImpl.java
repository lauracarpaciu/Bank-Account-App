package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.OrderEventRepository;
import com.lauracarpaciu.dao.OrderRepository;
import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.order.LineItem;
import com.lauracarpaciu.entities.order.Order;
import com.lauracarpaciu.entities.order.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;


public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderEventRepository orderEventRepository;


    @Override
    public Order createOrder(List<LineItem> lineItems) {
        return null;
    }

    public Boolean addOrderEvent(OrderEvent orderEvent, Boolean validate) throws Exception {
        Order order = orderRepository.findOne(Long.valueOf(orderEvent.getOrderId()));
        if (validate) {
            validateAccountNumber(order.getAccount());
        }
        orderEventRepository.save(orderEvent);

        return true;
    }

    @Override
    public List<Order> getOrdersForAccount(Account accountNumber) {
        List<Order> orders;
        validateAccountNumber(accountNumber);

        orders = orderRepository.findByAccountNumber(accountNumber);

        return orders.stream()
                .map(order -> getOrder(order.getOrderId(), true))
                .filter(order -> order != null)
                .collect(Collectors.toList());
    }

    @Override
    public Order getOrder(String orderId, Boolean validate) {
     return  null;
    }

    @Override
    public boolean validateAccountNumber(Account accountNumber) {
        return false;
    }
}
