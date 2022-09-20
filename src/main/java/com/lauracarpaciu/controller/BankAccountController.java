package com.lauracarpaciu.controller;


import com.lauracarpaciu.entity.bankAccount.BankAccount;
import com.lauracarpaciu.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BankAccountController {
  
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
		super();
		this.bankAccountService = bankAccountService;
	}
	public BankAccount saveAccount(BankAccount ct) {
        return bankAccountService.saveAccount(ct);
    }
    @RequestMapping(path = "/bankaccounts/{code}", method = RequestMethod.GET, name = "getAccount")
    public ResponseEntity<BankAccount> getAccount(@PathVariable("code")String code) throws Exception{
        return Optional.ofNullable(bankAccountService.getAccount(code)).map(result->new ResponseEntity<BankAccount>(result, HttpStatus.OK)).orElseThrow(()->new Exception("Not found"));

}}
