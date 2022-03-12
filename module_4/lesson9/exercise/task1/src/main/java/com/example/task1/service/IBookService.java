package com.example.task1.service;

import com.example.task1.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    void save(Book book);
    void delete(Book book);
    Book findById(Long id);
}
