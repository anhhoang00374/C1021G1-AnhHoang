package repository;

import model.Product;
import model.Student;

import java.util.List;

public interface IRepository {
    List findAll();

    void save(Product product);

    void delete(int id);

    void update(Product product);
}
