package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.BankAccountRepository;
import com.lauracarpaciu.dao.EmployeeRepository;
import com.lauracarpaciu.dao.OperationRepository;
import com.lauracarpaciu.entities.bankAccount.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationServiceImpl implements OperationService {
   
    private final OperationRepository operationRepository;
  
    private final BankAccountRepository bankAccountRepository;
 
    private final EmployeeRepository employeeRepository;
    @Autowired
    public OperationServiceImpl(OperationRepository operationRepository, BankAccountRepository bankAccountRepository,
			EmployeeRepository employeeRepository) {
		super();
		this.operationRepository = operationRepository;
		this.bankAccountRepository = bankAccountRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
    @Transactional
    public boolean pay(String accountName, double amount, Long employeeCode) {
        BankAccount ct = bankAccountRepository.findOne(accountName);
        Employee e = employeeRepository.findOne(employeeCode);
        Operation o = new Payment();
        o.setAmount(amount);
        o.setAccount(ct);
        o.setEmployee(e);
        operationRepository.save(o);
        ct.setBalance(ct.getBalance() + amount);

        return true;
    }

    @Override
    @Transactional
    public boolean withdrawal(String accountName, double amount, Long employeeCode) {
        BankAccount ct = bankAccountRepository.findOne(accountName);
        if (ct.getBalance() < amount) throw new RuntimeException("Insufficient sold");
        Employee e = employeeRepository.findOne(employeeCode);
        Operation o = new Withdrawal();
        o.setAmount(amount);
        o.setAccount(ct);
        o.setEmployee(e);
        operationRepository.save(o);
        ct.setBalance(ct.getBalance() - amount);

        return true;
    }

    @Override
    @Transactional
    public boolean virament(String account1, String account2, double amount, Long employeeCode) {

        withdrawal(account1, amount, employeeCode);
        pay(account2, amount, employeeCode);
        return true;
    }

    @Override
    public PageOperation getOperation(String accountName, int page, int size) {
        BankAccount ct = bankAccountRepository.findOne(accountName);
        Page<Operation> ops = operationRepository.findByAccount(ct, new PageRequest(page, size));
        PageOperation pOp = new PageOperation();
        pOp.setOperations(ops.getContent());
        pOp.setOpetationNumber(ops.getNumberOfElements());
        pOp.setPage(page);
        pOp.setTotalPages(ops.getTotalPages());
        pOp.setTotalOperations((int) ops.getTotalElements());

        return pOp;
    }
}
