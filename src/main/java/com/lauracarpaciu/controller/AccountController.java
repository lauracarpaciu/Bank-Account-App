package com.lauracarpaciu.controller;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<Account> getUserAccounts() throws Exception {
        return accountService.getUserAccounts();
    }

}
