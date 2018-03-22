package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.UserRepository;
import com.lauracarpaciu.entities.user.User;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }


}
