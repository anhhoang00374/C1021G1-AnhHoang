package code_gym.io_binary_file_serialization.exercise.service;

import code_gym.io_binary_file_serialization.exercise.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProductService implements IproductService {
    List<Product> listProduct = new ArrayList<>();
    final String PATH = "/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/code_gym/io_binary_file_serialization/data/product.txt";

    int random(){
        int num = 0;
        Random rd = new Random();
        num = rd.nextInt(26)+97;
        return  num;
    }
    String randomCode(){
        String result = "";
        for(int i = 0;i<6;i++){
            result+= (char)random();
        }
        return result;
    }


    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        String codeProduct = randomCode();
        System.out.println("please input name of product");
        String nameProduct = scanner.nextLine();
        System.out.println("please input producer");
        String producer = scanner.nextLine();
        boolean check = false;
        int price = 0;
        do {
            try{
                check = false;
                System.out.println("please input price of product");
                price = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("please input number");
                check = true;
            }
        }while (check);
        Product product = new Product(codeProduct,nameProduct,producer,price);
        listProduct.add(product);


    }

    @Override
    public void write() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);
            objectInputStream.writeObject(listProduct);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> read() {
        List<Product> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<Product>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> list= new ArrayList<>();
        for(Product product : listProduct){
            if(product.getNameProduct().contains(name)){
                list.add(product);
            }
        }
        return list;
    }
}
