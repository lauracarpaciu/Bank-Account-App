package com.lauracarpaciu.controller;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity getUserAccount() throws Exception {
        return Optional.ofNullable(accountService.getUserAccounts())
                .map(a -> new ResponseEntity<List<Account>>(a, HttpStatus.OK))
                .orElseThrow(() -> new Exception("Accounts for user do not exist"));
    }

}
