package com.example.case_study.service.impl;

import com.example.case_study.model.Education;
import com.example.case_study.repository.IEducationRepository;
import com.example.case_study.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService {
    @Autowired
    IEducationRepository educationRepository;
    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
}
