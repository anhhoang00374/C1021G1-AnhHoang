package service;

import model.Product;

import java.util.List;

public interface IProduct {
    void display();
    void create(Product product);
    void update(Product product);
    void delete(Product product);
    void displayDetail(Product product);
    List<Product> searchByName(int id);
}
