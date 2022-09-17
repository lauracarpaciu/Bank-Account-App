package com.lauracarpaciu.controller;

import com.lauracarpaciu.entities.user.User;
import com.lauracarpaciu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "/name",method = RequestMethod.GET)
    public ResponseEntity<?> name(Principal principal) {
        User user = null;
        if(principal != null) {
            user = userService.getUserByUsername(principal.getName());
        }

        return Optional.ofNullable(user)
                .map(a -> new ResponseEntity<User>(a, HttpStatus.OK))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
