package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.bankAccount.BankAccount;
import com.lauracarpaciu.entities.catalog.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{
}
