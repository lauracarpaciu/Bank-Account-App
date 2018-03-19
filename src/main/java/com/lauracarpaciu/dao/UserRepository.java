package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String>{

}
