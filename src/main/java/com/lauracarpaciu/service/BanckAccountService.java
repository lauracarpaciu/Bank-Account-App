package com.lauracarpaciu.service;


import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.bankAccount.BankAccount;

public interface BanckAccountService {
    BankAccount saveAccount(BankAccount ct);

    BankAccount getAccount(String code);

}
