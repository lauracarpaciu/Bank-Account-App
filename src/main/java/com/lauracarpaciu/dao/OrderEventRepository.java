package com.lauracarpaciu.dao;

import com.lauracarpaciu.entity.order.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderEventRepository extends JpaRepository<OrderEvent,String> {
    List<OrderEvent> findOrderEventsByOrderId(@Param("orderId") String orderId);
}
