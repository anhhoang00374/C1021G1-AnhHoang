package service.impl;

import model.Product;
import model.Student;
import repository.IRepository;
import repository.repoImpl.ProductRepo;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IRepository iRepository = new ProductRepo();

    @Override
    public List findAll() {
       return iRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iRepository.save(product);
    }

    @Override
    public void delete(int id) {
        iRepository.delete(id);
    }

    @Override
    public void update(Product product) {
        iRepository.update(product);
    }
}
