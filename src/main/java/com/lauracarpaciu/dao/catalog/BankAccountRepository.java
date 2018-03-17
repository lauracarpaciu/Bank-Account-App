package com.lauracarpaciu.dao.catalog;

import com.lauracarpaciu.entities.bankAccount.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String>{
}
