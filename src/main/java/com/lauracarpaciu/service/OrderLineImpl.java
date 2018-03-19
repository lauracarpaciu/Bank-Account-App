package com.lauracarpaciu.service;
import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.cart.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public class OrderLineImpl implements OrderLine {
    @Override
    public OrderLine addOrder(ShoppingCart cart, Account c) {
        return null;
    }
}
