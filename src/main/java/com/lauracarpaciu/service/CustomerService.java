package com.lauracarpaciu.service;

import com.lauracarpaciu.entities.customer.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer c);

    List<Customer> listClient();

}
