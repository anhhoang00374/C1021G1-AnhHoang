package com.example.task1.repositoty;

import com.example.task1.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedBookRepository extends JpaRepository<BorrowedBook,Long> {
    BorrowedBook findBorrowedBookByBorrowedNumberContaining(String number);
}
