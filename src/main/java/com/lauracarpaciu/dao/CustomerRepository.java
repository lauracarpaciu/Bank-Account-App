package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
}
