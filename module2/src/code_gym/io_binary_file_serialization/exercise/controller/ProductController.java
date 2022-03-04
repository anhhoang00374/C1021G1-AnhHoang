package code_gym.io_binary_file_serialization.exercise.controller;

import code_gym.io_binary_file_serialization.exercise.model.Product;
import code_gym.io_binary_file_serialization.exercise.service.ProductService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        List<Product> listProduct = new ArrayList<>();
        List<Product> listSearch = new ArrayList<>();
        boolean checkLoop = true;
        int numberToRun;
        do{
            checkLoop = false;
            System.out.println("Manager products");
            System.out.println("1. add product");
            System.out.println("2. display products");
            System.out.println("3. search by name");
            System.out.println("other exits");
            try{
                numberToRun = Integer.parseInt(scanner.nextLine());
            }catch ( Exception e) {
                System.out.println("number error. please input again ");
                checkLoop = true;
                continue;
            }
            switch (numberToRun){
                case 1:
                    productService.add();
                    productService.write();
                    break;
                case 2:
                    try {
                        listProduct = productService.read();
                        for(Product product : listProduct){
                            System.out.println(product);
                        }
                    }catch (Exception e){
                        System.out.println("file not data");
                    }
                    break;
                case 3:
                    String name = scanner.nextLine();
                    listSearch = productService.search(name);
                    for(Product product: listSearch){
                        System.out.println(product);
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
            checkLoop = true;

        }while (checkLoop);

    }
}
