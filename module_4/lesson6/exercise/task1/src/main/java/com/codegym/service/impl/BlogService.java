package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public void add(Blog blog) {
        iBlogRepository.add(blog);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAdd();
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iBlogRepository.remove(id);
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepository.edit(blog);
    }
}
