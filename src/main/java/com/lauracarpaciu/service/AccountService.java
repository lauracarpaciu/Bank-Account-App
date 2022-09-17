package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.user.User;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface AccountService {
    List<Account> getUserAccounts(String userName, Long id);

    User getAuthenticatedUser(Long id);
}
