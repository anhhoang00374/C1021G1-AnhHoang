package com.example.task1.service.impl;

import com.example.task1.model.BorrowedBook;
import com.example.task1.repositoty.IBorrowedBookRepository;
import com.example.task1.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowedService implements IBorrowedBookService {
    @Autowired
    IBorrowedBookRepository borrowedBookRepository;
    @Override
    public void save(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public BorrowedBook findByborrowedNumber(String number) {
        return borrowedBookRepository.findBorrowedBookByBorrowedNumberContaining(number);
    }

    @Override
    public void delete(BorrowedBook borrowedBook) {
        borrowedBookRepository.delete(borrowedBook);
    }
}
