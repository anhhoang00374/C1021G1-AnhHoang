package service;

import model.Product;
import model.Student;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    void delete(int id);

    void update(Product product);
}
