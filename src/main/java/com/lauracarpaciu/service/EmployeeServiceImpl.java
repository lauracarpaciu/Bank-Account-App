package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.EmployeeRepository;
import com.lauracarpaciu.entities.bankAccount.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl  implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }


}
