package com.example.case_study.service;

import com.example.case_study.model.Customer;
import com.example.case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    void deleteById(Long id);

    Employee findById(Long id);

    void delete(Employee employee);

    Page<Employee> findByName(String search, Pageable pageable);
}
