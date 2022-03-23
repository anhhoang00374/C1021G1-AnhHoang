package com.example.case_study.service;

import com.example.case_study.model.Customer;
import com.example.case_study.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void deleteById(Long id);

    Customer findById(Long id);

    void delete(Customer customer);

    Page<Customer> findByName(String search, Pageable pageable);
}
