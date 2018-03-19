package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
