package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> productList(Pageable pageable);
    void save(Product product);
    void delete(Product product);
    Product findById(Long id);
}
