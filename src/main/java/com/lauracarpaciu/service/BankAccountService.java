package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.bankAccount.BankAccount;

public interface BankAccountService {
    BankAccount saveAccount(BankAccount ct);

    BankAccount getAccount(String code);

}
