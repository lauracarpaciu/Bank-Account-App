package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.UserRepository;
import com.lauracarpaciu.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String userName) {
        return userRepository.findUserByUsername(userName);
    }


}
