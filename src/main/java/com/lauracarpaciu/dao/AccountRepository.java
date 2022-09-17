package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<Account,String>{
    List<Account> findAccountsByUserId(@Param("userName") String userName);
}
