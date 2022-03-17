package com.example.task2.repository;

import com.example.task2.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<SmartPhone,Long> {
}
