package com.lauracarpaciu.service;


import com.lauracarpaciu.dao.AccountRepository;
import com.lauracarpaciu.dao.UserRepository;
import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public User getAuthenticatedUser(Long id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    public List<Account> getUserAccounts(String userName, Long id) {
        List<Account> account = null;
        User user = getAuthenticatedUser(id);
        if (user != null) {
            account = accountRepository.findAccountsByUserId(userName);
        }

        if (account != null) {
            account.forEach(acct -> acct.getCreditCards()
                    .forEach(card ->
                            card.setNumber(card.getNumber()
                                    .replaceAll("([\\d]{4})(?!$)", "****-"))));
        }

        return account;
    }


}