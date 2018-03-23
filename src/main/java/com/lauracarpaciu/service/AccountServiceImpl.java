package com.lauracarpaciu.service;


import com.lauracarpaciu.dao.AccountRepository;
import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.user.User;
import org.hibernate.annotations.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    @Loader
    private OAuth2RestTemplate oAuth2RestTemplate;

    @Override
    public List<Account> getUserAccounts() {
        List<Account> accounts = null;
        User user = oAuth2RestTemplate.getForObject("http://gestiune/users/name",User.class);
        if (user != null) {
            accounts = accountRepository.findAccountsByUserId(user.getUserName());

            if (accounts != null) {
                accounts.forEach(acct -> acct.getCreditCards().forEach(creditCard -> creditCard.setNumber(creditCard.getNumber().replaceAll("([\\d]{6})(?!$)", "******-"))));

            }}
            return accounts;

    }
}