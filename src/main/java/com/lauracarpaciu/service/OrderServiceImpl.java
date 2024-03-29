package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.OrderEventRepository;
import com.lauracarpaciu.dao.OrderRepository;
import com.lauracarpaciu.entity.account.Account;
import com.lauracarpaciu.entity.order.LineItem;
import com.lauracarpaciu.entity.order.Order;
import com.lauracarpaciu.entity.order.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
  
    private final OrderRepository orderRepository;

    private final OrderEventRepository orderEventRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderEventRepository orderEventRepository) {
		super();
		this.orderRepository = orderRepository;
		this.orderEventRepository = orderEventRepository;
	}

	@Override
    public Order createOrder(List<LineItem> lineItems) {
        return null;
    }

    public boolean addOrderEvent(OrderEvent orderEvent, Boolean validate, String orderId) throws Exception {
        Order order = orderRepository.findOne(Long.valueOf(orderId));
        if (validate) {
            validateAccountNumber(order.getOrderId());
        }
        orderEventRepository.save(orderEvent);

        return true;
    }

    @Override
    public List<Order> getOrdersForAccount(String orderId) {
        List<Order> orders;
        validateAccountNumber(orderId);

        orders = orderRepository.findOrderByOrderId(orderId);

        return orders.stream()
                .map(order -> getOrder(order.getOrderId(), true))
                .filter(order -> order != null)
                .collect(Collectors.toList());
    }

    @Override
    public Order getOrder(String orderId, Boolean validate) {
        return null;
    }

    @Override
    public boolean validateAccountNumber(String orderId) {
        return false;
    }
}
