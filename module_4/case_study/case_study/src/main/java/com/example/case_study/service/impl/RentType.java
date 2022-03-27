package com.example.case_study.service.impl;

import com.example.case_study.repository.IRentypeRepository;
import com.example.case_study.service.IRentypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentType implements IRentypeService {
    @Autowired
    IRentypeRepository rentypeRepository;
    @Override
    public List<com.example.case_study.model.RentType> findAll() {
        return rentypeRepository.findAll();
    }
}
