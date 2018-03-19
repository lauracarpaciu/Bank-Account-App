package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.cart.CartEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.event.CaretEvent;
import java.util.List;

public interface CartEventRepository extends JpaRepository<CaretEvent,Long> {
    List<CartEvent>getCartEventbyUser(Long userId);
}
