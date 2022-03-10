package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    void add(Category category);
    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);

    void remove(Long id);

    void edit(Category category);
}
