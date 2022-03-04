package code_gym.io_binary_file_serialization.exercise.service;

import code_gym.io_binary_file_serialization.exercise.model.Product;

import java.util.List;

public interface IproductService {
    void add();
    void write();
    List<Product> read();
    List<Product> search(String name);
}
