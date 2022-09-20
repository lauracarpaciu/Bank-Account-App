package com.lauracarpaciu.service;

import com.lauracarpaciu.entity.account.Account;
import com.lauracarpaciu.entity.user.User;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface AccountService {
    List<Account> getUserAccounts(String userId,Long id);

    User getAuthenticatedUser(Long id);
}
