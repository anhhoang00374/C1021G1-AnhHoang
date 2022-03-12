package com.example.task1.service.impl;

import com.example.task1.model.Customer;
import com.example.task1.repositoty.ICustomerRepository;
import com.example.task1.repositoty.impl.CustomerRepository;
import com.example.task1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Customer findCustomerByName(String customerName) {
        return customerRepository.findByNameCustomer(customerName);
    }
}
