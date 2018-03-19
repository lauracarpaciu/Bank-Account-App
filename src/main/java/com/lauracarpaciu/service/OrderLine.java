package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.cart.ShoppingCart;


public interface OrderLine {

    OrderLine addOrder(ShoppingCart cart, Account c);
}
