package com.lauracarpaciu.controller;

import com.lauracarpaciu.entity.customer.Customer;
import com.lauracarpaciu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
 
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<Customer> saveCustomer(Customer c) throws Exception {
        return Optional.ofNullable(customerService.saveCustomer(c))
                .map(a -> new ResponseEntity<Customer>(a, HttpStatus.OK))
                .orElseThrow(() -> new Exception("Not found"));

    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listClient() throws Exception {
        return Optional.ofNullable(customerService.listClient())
                .map(a -> new ResponseEntity<List<Customer>>(a, HttpStatus.OK))
                .orElseThrow(() -> new Exception("Not found"));
    }
}
