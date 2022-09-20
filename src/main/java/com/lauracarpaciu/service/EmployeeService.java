package com.lauracarpaciu.service;


import com.lauracarpaciu.entity.bankAccount.Employee;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface EmployeeService {
    Employee saveEmployee(Employee e);

    List<Employee> listEmployees();


}
