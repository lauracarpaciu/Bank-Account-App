package com.lauracarpaciu.service;


import com.lauracarpaciu.entities.bankAccount.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee e);

    List<Employee> listEmployees();


}
