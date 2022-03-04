package com.codegym.service.imlp;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static Map<Integer,Product> productList = new HashMap<>();
    static {
        productList.put(1,new Product(1,"Cake","10000","good","VN"));
        productList.put(2,new Product(2,"Oshi","5000","good","USA"));
        productList.put(3,new Product(3,"Water","7000","good","VN"));
        productList.put(4,new Product(4,"Pepsi","10000","good","KOREA"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void create(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public Product view(int id) {
        return productList.get(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Map.Entry<Integer,Product> entry : productList.entrySet()) {
           if(entry.getValue().getProductName().toLowerCase().equals(name.toLowerCase())){
               products.add(entry.getValue());
           }
        }
        return products;
    }

    @Override
    public int lastId() {
        Product lastProduct = findAll().get(findAll().size()-1);
        return lastProduct.getId();
    }
}
