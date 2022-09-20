package com.lauracarpaciu.service;


import com.lauracarpaciu.dao.CustomerRepository;
import com.lauracarpaciu.entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
    public Customer saveCustomer(Customer c) {
        return customerRepository.save(c);
    }


    @Override
    public List<Customer> listClient() {
        return customerRepository.findAll();
    }
}
