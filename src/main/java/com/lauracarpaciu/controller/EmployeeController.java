package com.lauracarpaciu.controller;

import com.lauracarpaciu.entities.bankAccount.Employee;
import com.lauracarpaciu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employes", method = RequestMethod.POST)
    public ResponseEntity<Employee> saveEmployee(Employee e) throws Exception {
        return Optional.ofNullable(employeeService.saveEmployee(e))
                .map(a -> new ResponseEntity<Employee>(a, HttpStatus.OK))
                .orElseThrow(() -> new Exception("Not found"));
    }


    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity listEmployees() throws Exception {
        return Optional.ofNullable(employeeService.listEmployees())
                .map(a -> new ResponseEntity<List<Employee>>(a, HttpStatus.OK))
                .orElseThrow(() -> new Exception("Not found"));
    }
}
