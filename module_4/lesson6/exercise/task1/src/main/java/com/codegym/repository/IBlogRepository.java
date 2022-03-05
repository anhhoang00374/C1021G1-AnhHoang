package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogRepository {
    void add(Blog blog);
    List<Blog> findAdd();

    Blog findById(Long id);

    void remove(Long id);

    void edit(Blog blog);

    List<Blog> search();
}
