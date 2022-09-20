package com.lauracarpaciu.controller;

import com.lauracarpaciu.entity.order.LineItem;
import com.lauracarpaciu.entity.order.Order;
import com.lauracarpaciu.entity.order.OrderEvent;
import com.lauracarpaciu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class OrderController {
  
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	public Order createOrder(List<LineItem> lineItems) {
        return orderService.createOrder(lineItems);
    }

    @RequestMapping(value = "/orders/{orderId}/events", method = RequestMethod.POST)
    public ResponseEntity<?> addOrderEvent(@RequestBody OrderEvent orderEvent,Boolean validate,
                                        @PathVariable("orderId") String orderId) throws Exception {
        assert orderEvent != null;
        assert orderId != null;
        assert !Objects.equals(orderId, orderEvent.getOrderId());
        return Optional.ofNullable(orderService.addOrderEvent(orderEvent, true,orderId))
                .map(a -> new ResponseEntity<>(HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new Exception("Order event could not be applied to order"));
    }

    @RequestMapping(value = "/orders/{orderId}",method = RequestMethod.GET)
    public ResponseEntity<?> getOrder(@PathVariable("orderId") String orderId) throws Exception {
        assert orderId != null;
        return Optional.ofNullable(orderService.getOrder(orderId, true))
                .map(a -> new ResponseEntity<Order>(a, HttpStatus.OK))
                .orElseThrow(() -> new Exception("Could not retrieve order"));
    }

    public Order getOrder(String orderId, Boolean validate) {
        return orderService.getOrder(orderId, validate);
    }

    public boolean validateAccountNumber(String orderId) {
        return orderService.validateAccountNumber(orderId);
    }




}
