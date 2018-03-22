package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.BankAccountRepository;
import com.lauracarpaciu.entities.bankAccount.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository accountRepository;

    @Override
    public BankAccount saveAccount(BankAccount ct) {

        return accountRepository.save(ct);
    }

    @Override
    public BankAccount getAccount(String code) {
        BankAccount ct = accountRepository.findOne(code);
        if (ct == null) throw new RuntimeException("Account innexistent");
        return ct;
    }
}
