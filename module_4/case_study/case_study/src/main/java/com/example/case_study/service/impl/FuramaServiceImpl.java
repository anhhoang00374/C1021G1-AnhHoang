package com.example.case_study.service.impl;

import com.example.case_study.model.FuramaService;
import com.example.case_study.repository.IServiceRepository;
import com.example.case_study.service.IFuramaSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuramaServiceImpl implements IFuramaSevice {
    @Autowired
    IServiceRepository serviceRepository;

    @Override
    public List<FuramaService> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<FuramaService> findAll(Pageable pageable) {
        Page<FuramaService> services = serviceRepository.findAll(pageable);
        return services;
    }

    @Override
    public void save(FuramaService furamaService) {
        serviceRepository.save(furamaService);
    }
}
