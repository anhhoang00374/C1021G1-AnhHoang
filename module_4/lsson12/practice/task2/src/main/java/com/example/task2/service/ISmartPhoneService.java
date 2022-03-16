package com.example.task2.service;

import com.example.task2.model.SmartPhone;

import java.util.List;

public interface ISmartPhoneService {
    List<SmartPhone> findAll();
    SmartPhone findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
