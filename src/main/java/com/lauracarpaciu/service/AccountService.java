package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.account.Account;

import java.util.List;

public interface AccountService {
    List<Account> getUserAccounts(String userName);
}
