package com.lauracarpaciu.dao.catalog;

import com.lauracarpaciu.entities.bankAccount.BankAccount;
import com.lauracarpaciu.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{
}
