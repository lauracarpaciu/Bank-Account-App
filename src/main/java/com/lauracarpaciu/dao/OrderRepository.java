package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByAccountNumber(Account account);
}
