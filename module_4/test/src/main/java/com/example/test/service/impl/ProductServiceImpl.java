package com.example.test.service.impl;

import com.example.test.model.Product;
import com.example.test.model.Type;
import com.example.test.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository productRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public void remove(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Page<Product> searchAll(String name, Float price, String type, Pageable pageable) {
        return productRepository.findAllByNameContainingAndPriceIsGreaterThanAndType_Name(name, price, type, pageable);
    }

    @Override
    public Page<Product> searchByNameAndPrice(String searchName, Float price, Pageable pageable) {
        return productRepository.findByNameContainingAndPriceIsGreaterThan(searchName,price,pageable);
    }
}
