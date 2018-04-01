package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.cart.CartEvent;
import com.lauracarpaciu.entities.user.User;

public interface ShoppingCartService {
    Boolean addCartEvent(CartEvent cartEvent, Long id);

    Boolean addCartEvent(CartEvent cartEvent, User user);
//    ShoppingCart getShoppingCart(String userName, Long categoryId);

}
