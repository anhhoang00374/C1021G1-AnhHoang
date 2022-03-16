package com.example.task2.service.impl;

import com.example.task2.model.SmartPhone;
import com.example.task2.repository.ICustomerRepository;
import com.example.task2.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneService implements ISmartPhoneService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public List<SmartPhone> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public SmartPhone findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return customerRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        if(customerRepository.findById(id)!=null){
            customerRepository.deleteById(id);
        }
    }
}
