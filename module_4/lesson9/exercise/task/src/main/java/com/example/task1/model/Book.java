package com.example.task1.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private int quantity;
    private int currentQuantity;
    private String name;
    @OneToMany(mappedBy = "book")
    private List<BorrowedBook> borrowedBook;

    public Book() {
    }

    public Book(int quantity, int currentQuantity, String name) {
        this.quantity = quantity;
        this.currentQuantity = currentQuantity;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BorrowedBook> getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(List<BorrowedBook> borrowedBook) {
        this.borrowedBook = borrowedBook;
    }
}
