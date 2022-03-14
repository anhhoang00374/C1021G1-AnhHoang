package com.example.demo.dto;

import com.example.demo.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    Map<Product,Integer> productList = new HashMap<>();

    public Cart() {
    }

    public Map<Product, Integer> getProductList() {
        return productList;
    }

    public void setProductList(Map<Product, Integer> productList) {
        this.productList = productList;
    }

    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            productList.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            productList.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Integer countItemQuantity(){
        return productList.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public Set<Map.Entry<Product, Integer>> findAll(){
        return this.productList.entrySet();
    }
}
