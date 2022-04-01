package com.example.test.service.impl;

import com.example.test.model.Product;
import com.example.test.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Product findById(Long id);
    void remove(Product product);
    Page<Product> searchAll(String name,Float price,String type,Pageable pageable);

    Page<Product> searchByNameAndPrice(String searchName, Float price, Pageable pageable);
}
