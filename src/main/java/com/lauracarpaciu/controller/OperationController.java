package com.lauracarpaciu.controller;

import com.lauracarpaciu.service.OperationService;
import com.lauracarpaciu.service.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OperationController {

    @Autowired
    private OperationService operationService;

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public ResponseEntity getOperationService(@RequestParam String codCont, @RequestParam int page, @RequestParam int size) throws Exception {
        return Optional.ofNullable(operationService.getOperation(codCont, page, size))
                .map(a -> new ResponseEntity<PageOperation>(a, HttpStatus.OK))
                .orElseThrow(() -> new Exception("Not found"));
    }


    @RequestMapping(value = "/payment", method = RequestMethod.PUT)
    public ResponseEntity pay(@RequestParam String code, @RequestParam double amount, @RequestParam Long employeeCode) throws Exception{
        return Optional.ofNullable(operationService.pay(code, amount, employeeCode)).map(a-> new ResponseEntity<>(a,HttpStatus.OK)).orElseThrow(()->new Exception("Not found"));
    }

    @RequestMapping(value = "/withdrawal", method = RequestMethod.PUT)
    public boolean retire(@RequestParam String code, @RequestParam double amount, @RequestParam Long employeeCode) {
        return operationService.withdrawal(code, amount, employeeCode);
    }

    @RequestMapping(value = "/virament", method = RequestMethod.PUT)
    public boolean virament(@RequestParam String account1, @RequestParam String account2, @RequestParam double amount, @RequestParam Long employeeCode) {
        return operationService.virament(account1, account2, amount, employeeCode);
    }
}
