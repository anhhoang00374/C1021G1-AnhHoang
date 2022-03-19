package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findByTitleContaining(String name, Pageable pageable);
//    void add(Blog blog);
//    List<Blog> findAdd();
//
//    Blog findById(Long id);
//
//    void remove(Long id);
//
//    void edit(Blog blog);
//
//    List<Blog> search();
}
