package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    void add(Blog blog);
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void remove(Long id);

    void edit(Blog blog);

    Page<Blog> search(String name,Pageable pageable);
}
