package com.example.test.repository;

import com.example.test.model.Product;
import com.example.test.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByNameContainingAndPriceIsGreaterThan(String name,Float price,Pageable pageable);
    Page<Product> findAllByNameContainingAndPriceIsGreaterThanAndType_Name(String name, Float price, String typeName, Pageable pageable);
}
