package com.example.task1.repositoty;

import com.example.task1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByNameCustomer(String customerName);
}
