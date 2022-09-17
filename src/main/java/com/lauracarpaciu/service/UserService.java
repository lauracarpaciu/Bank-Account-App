package com.lauracarpaciu.service;

import org.springframework.stereotype.Service;

import com.lauracarpaciu.entities.user.User;
@Service
public interface UserService {
    User getUserByUsername(String userName);
}
