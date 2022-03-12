package com.example.task1.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String borrowedNumber;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;
    @ManyToOne()
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    public BorrowedBook() {
    }

    public BorrowedBook(String borrowedNumber, Book book, Customer customer) {
        this.borrowedNumber = borrowedNumber;
        this.book = book;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowedNumber() {
        return borrowedNumber;
    }

    public void setBorrowedNumber(String borrowedNumber) {
        this.borrowedNumber = borrowedNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
