package com.lauracarpaciu.service;

import org.springframework.stereotype.Service;

import com.lauracarpaciu.entities.bankAccount.BankAccount;
@Service
public interface BankAccountService {
    BankAccount saveAccount(BankAccount ct);

    BankAccount getAccount(String code);

}
