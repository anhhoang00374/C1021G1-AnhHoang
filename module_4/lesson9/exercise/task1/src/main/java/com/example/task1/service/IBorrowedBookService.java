package com.example.task1.service;

import com.example.task1.model.BorrowedBook;

public interface IBorrowedBookService {
    void save(BorrowedBook borrowedBook);

    BorrowedBook findByborrowedNumber(String number);
    void delete(BorrowedBook borrowedBook);
}
