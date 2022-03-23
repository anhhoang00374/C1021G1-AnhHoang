package com.example.case_study.repository;

import com.example.case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findByNameContaining(String search, Pageable pageable);
}
