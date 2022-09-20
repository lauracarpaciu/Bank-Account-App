package com.lauracarpaciu.dao;

import com.lauracarpaciu.entity.bankAccount.BankAccount;
import com.lauracarpaciu.entity.bankAccount.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Page<Operation> findByAccount(BankAccount ct, Pageable pageable);

}
