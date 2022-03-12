package com.example.task1.service;

import com.example.task1.model.Customer;

public interface ICustomerService {

    Customer findCustomerByName(String customerName);
}
