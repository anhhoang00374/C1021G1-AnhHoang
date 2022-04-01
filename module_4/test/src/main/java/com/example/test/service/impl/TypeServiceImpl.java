package com.example.test.service.impl;

import com.example.test.model.Product;
import com.example.test.model.Type;
import com.example.test.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService {
    @Autowired
    ITypeRepository customerRepository;


    @Override
    public List<Type> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Type findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
