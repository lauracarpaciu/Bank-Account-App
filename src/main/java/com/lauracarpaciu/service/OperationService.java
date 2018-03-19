package com.lauracarpaciu.service;

public interface OperationService {

    boolean pay(String accountName, double amount, Long employeeCode);

    boolean withdrawal(String accountName, double amount, Long employeeCode);

    boolean virament(String account1, String account2, double amount, Long employeeCode);

    PageOperation getOperation(String codCont, int page, int size);


}
