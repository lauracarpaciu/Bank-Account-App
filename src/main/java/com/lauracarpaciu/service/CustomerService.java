package com.lauracarpaciu.service;

import com.lauracarpaciu.entity.customer.Customer;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CustomerService {
    Customer saveCustomer(Customer c);

    List<Customer> listClient();

}
