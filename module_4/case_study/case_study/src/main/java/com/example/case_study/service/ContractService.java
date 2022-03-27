package com.example.case_study.service;

import com.example.case_study.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    void AddNew(Contract contract);
    Page<Contract> findAll(Pageable pageable);
}
