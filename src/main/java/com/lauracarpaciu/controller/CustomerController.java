package com.lauracarpaciu.controller;

import com.lauracarpaciu.entities.customer.Customer;
import com.lauracarpaciu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public Customer saveCustomer(Customer c) {
        return customerService.saveCustomer(c);
    }

    public List<Customer> listClient() {
        return customerService.listClient();
    }
}
