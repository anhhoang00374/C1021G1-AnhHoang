package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;
    private String source;
    private Long timeAdd;

    public Product() {
    }

    public Product(String name, double price, String description, String source, Long timeAdd) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.source = source;
        this.timeAdd = timeAdd;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getTimeAdd() {
        return timeAdd;
    }

    public void setTimeAdd(Long timeAdd) {
        this.timeAdd = timeAdd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && id.equals(product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(source, product.source) && Objects.equals(timeAdd, product.timeAdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, source, timeAdd);
    }
}
