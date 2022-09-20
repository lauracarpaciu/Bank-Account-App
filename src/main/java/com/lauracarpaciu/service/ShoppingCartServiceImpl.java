package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.CartEventRepository;
import com.lauracarpaciu.dao.CategoryRepository;
import com.lauracarpaciu.dao.UserRepository;
import com.lauracarpaciu.entity.cart.CartEvent;
import com.lauracarpaciu.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

  
    private final UserRepository userRepository;

    private final CartEventRepository cartEventRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public ShoppingCartServiceImpl(UserRepository userRepository, CartEventRepository cartEventRepository,
			CategoryRepository categoryRepository) {
		super();
		this.userRepository = userRepository;
		this.cartEventRepository = cartEventRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
    public Boolean addCartEvent(CartEvent cartEvent, Long id) {
        User user = userRepository.findOne(id);
        if (user != null) {
            cartEvent.setUserId(user.getId());
            cartEventRepository.save(cartEvent);
        } else {
            return null;
        }
        return true;
    }

    @Override
    public Boolean addCartEvent(CartEvent cartEvent, User user) {
        if (user != null) {
            cartEvent.setUserId(user.getId());
            cartEventRepository.save(cartEvent);
        } else {
            return null;
        }
        return true;
    }

//    @Override
//    public ShoppingCart getShoppingCart(String userName, Long categoryId) {
//        User user = userRepository.findOne(userName);
//        ShoppingCart shoppingCart = null;
//        if (user != null) {
//            Category category = categoryRepository.findOne(categoryId);
//            shoppingCart = aggregateCartEvents(user,category);
//        }
//        return shoppingCart;
//    }


}
