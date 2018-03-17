package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.account.Account;
import com.lauracarpaciu.entities.bankAccount.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OperationRepository extends JpaRepository<Operation, Long> {
    Page<Operation> findByAccount(Account ct, Pageable pageable);

}
