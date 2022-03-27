package com.example.case_study.service.impl;

import com.example.case_study.repository.IServiceTypeRepository;
import com.example.case_study.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceType implements IServiceTypeService {
    @Autowired
    IServiceTypeRepository serviceTypeRepository;
    @Override
    public List<com.example.case_study.model.ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
