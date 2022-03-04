package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void create(Product product);
    void update(Product product);
    void delete(int id);
    Product view(int id);
    List<Product> searchByName(String name);
    int lastId();

}
