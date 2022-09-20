package com.lauracarpaciu.dao;

import com.lauracarpaciu.entity.cart.CartEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.event.CaretEvent;
import java.util.List;
@Repository
public interface CartEventRepository extends JpaRepository<CaretEvent,Long> {
    List<CartEvent>getCartEventbyUser(Long userId);

    void save(CartEvent cartEvent);
}
