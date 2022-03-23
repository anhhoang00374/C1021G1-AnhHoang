package com.example.case_study.service;

import com.example.case_study.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDivisionService{
    List<Division> findAll();
}
