package com.example.case_study.service.impl;

import com.example.case_study.repository.IComplimentaryRepository;
import com.example.case_study.service.IComplimentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Complimentary implements IComplimentaryService {
    @Autowired
    IComplimentaryRepository complimentaryRepository;
    @Override
    public List<com.example.case_study.model.Complimentary> findAll() {
        return complimentaryRepository.findAll();
    }
}
