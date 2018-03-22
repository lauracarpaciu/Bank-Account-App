package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.user.User;

public interface UserService {
  User getUserByUsername(String username);
}
