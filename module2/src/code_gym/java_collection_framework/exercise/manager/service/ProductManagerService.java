package code_gym.java_collection_framework.exercise.manager.service;

import code_gym.java_collection_framework.exercise.manager.model.ProductManager;

import java.util.*;

public class ProductManagerService {
    Scanner sc = new Scanner(System.in);
    List<ProductManager> arraylist = new ArrayList<>();
    public void add(ProductManager product){
        arraylist.add(product);
    }
    public void remove(int id){
        if(id>arraylist.get(arraylist.size()-1).getProductId()){
            System.out.println("lỗi id");
        }else{
            for(int i = 0;i<arraylist.size();i++){
                if(arraylist.get(i).getProductId()==id){
                    arraylist.remove(i);
                }
            }
        }

    }

    public ProductManager search(String name){
        for(ProductManager product: arraylist){
            if(product.getName().contains(name)){
                return product;
            }
        }
        return null;
    }

    public void update(int id){
        if(id>arraylist.get(arraylist.size()-1).getProductId()||
                id<0
        ){
            System.out.println("lỗi id");
        }else{
            for(ProductManager product: arraylist){
                if(product.getProductId() == id){
                    product.setName(sc.nextLine());
                    product.setPrice(sc.nextInt());
                }
            }
        }


    }
    public void displayPriceUp(){
        Collections.sort(arraylist, new Comparator<ProductManager>() {
            @Override
            public int compare(ProductManager o1, ProductManager o2) {
                return o1.getPrice()-o2.getPrice();
            }
        });
        for(ProductManager product: arraylist){
            System.out.println(product);
        }
    }

    public void displayPriceDown(){
        Collections.sort(arraylist, new Comparator<ProductManager>() {
            @Override
            public int compare(ProductManager o1, ProductManager o2) {
                return o2.getPrice()-o1.getPrice();
            }
        });
        for(ProductManager product: arraylist){
            System.out.println(product);
        }
    }
}
