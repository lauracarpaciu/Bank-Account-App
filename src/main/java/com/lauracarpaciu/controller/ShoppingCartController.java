package com.lauracarpaciu.controller;

import com.lauracarpaciu.entity.cart.CartEvent;
import com.lauracarpaciu.entity.user.User;
import com.lauracarpaciu.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ShoppingCartController {
    /**
     *
     */
    
    private final ShoppingCartService shoppingCartService;
    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
		super();
		this.shoppingCartService = shoppingCartService;
	}

	@RequestMapping(path = "/shoppingCart", method = RequestMethod.POST)
    public ResponseEntity<?> addCartEvent(@RequestBody CartEvent cartEvent,@RequestBody User user) throws Exception {
        return Optional.ofNullable(shoppingCartService.addCartEvent(cartEvent,user))
                .map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new Exception("Could not find shopping cart"));
    }

    @RequestMapping(path = "/shoppingCart", method = RequestMethod.POST)
    public ResponseEntity<?> addCartEvent(@RequestBody CartEvent cartEvent,@RequestBody Long id) throws Exception {
        return Optional.ofNullable(shoppingCartService.addCartEvent(cartEvent,id))
                .map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new Exception("Could not find shopping cart"));
    }
}
