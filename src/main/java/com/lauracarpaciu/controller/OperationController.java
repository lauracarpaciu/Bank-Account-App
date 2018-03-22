package com.lauracarpaciu.controller;

import com.lauracarpaciu.service.OperationService;
import com.lauracarpaciu.service.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {

    @Autowired
    private OperationService operationService;


    public boolean pay(String accountName, double amount, Long employeeCode) {
        return operationService.pay(accountName, amount, employeeCode);
    }

    public boolean withdrawal(String accountName, double amount, Long employeeCode) {
        return operationService.withdrawal(accountName, amount, employeeCode);
    }

    public boolean virament(String account1, String account2, double amount, Long employeeCode) {
        return operationService.virament(account1, account2, amount, employeeCode);
    }

    public PageOperation getOperation(String codCont, int page, int size) {
        return operationService.getOperation(codCont, page, size);
    }
}
