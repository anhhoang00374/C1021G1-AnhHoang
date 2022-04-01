package com.example.test.service.impl;

import com.example.test.model.Product;
import com.example.test.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITypeService {
    List<Type> findAll();
//    void save(Type product);
    Type findById(Long id);
//    void remove(Type product);
}
