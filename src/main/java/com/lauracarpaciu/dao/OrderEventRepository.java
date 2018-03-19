package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.order.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface OrderEventRepository extends JpaRepository<OrderEvent,String> {
    List<OrderEvent> findOrderEventsByOrderId(@Param("orderId") String orderId);
}
