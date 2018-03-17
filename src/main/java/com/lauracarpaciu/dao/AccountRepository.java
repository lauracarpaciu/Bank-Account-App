package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,String>{
    List<Account> findAccountsByUserId(@Param("userId") String userId);
}
