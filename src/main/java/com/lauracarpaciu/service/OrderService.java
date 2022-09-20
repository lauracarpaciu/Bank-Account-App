package com.lauracarpaciu.service;


import com.lauracarpaciu.entity.order.LineItem;
import com.lauracarpaciu.entity.order.Order;
import com.lauracarpaciu.entity.order.OrderEvent;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface OrderService {

    Order createOrder(List<LineItem> lineItems);

    boolean addOrderEvent(OrderEvent orderEvent, Boolean validate, String orderId) throws Exception;

    Order getOrder(String orderId, Boolean validate);

	List<Order> getOrdersForAccount(String orderId);

	boolean validateAccountNumber(String orderId);
}
