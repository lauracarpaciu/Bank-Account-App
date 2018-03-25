package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.cart.CartEvent;
import com.lauracarpaciu.entities.user.User;

public interface ShoppingCartService {
    User getAuthenticatedUser(String userName);
    Boolean addCartEvent(CartEvent cartEvent,String userName);
    Boolean addCartEvent(CartEvent cartEvent, User user);
//    ShoppingCart getShoppingCart(String userName, Long categoryId);

}
