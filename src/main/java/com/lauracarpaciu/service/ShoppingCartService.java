package com.lauracarpaciu.service;

import org.springframework.stereotype.Service;

import com.lauracarpaciu.entities.cart.CartEvent;
import com.lauracarpaciu.entities.user.User;
@Service
public interface ShoppingCartService {
    Boolean addCartEvent(CartEvent cartEvent, Long id);

    Boolean addCartEvent(CartEvent cartEvent, User user);
//    ShoppingCart getShoppingCart(String userName, Long categoryId);

}
