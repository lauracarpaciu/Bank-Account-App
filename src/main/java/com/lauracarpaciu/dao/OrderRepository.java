package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByAccountNumber(Account account);
}
