package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.bankAccount.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
