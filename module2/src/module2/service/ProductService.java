package module2.service;

import module2.model.ExportProduct;
import module2.model.ImportProduct;
import module2.model.Product;
import module2.utils.IOFIle;
import module2.utils.NotFoundProductException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProduct{
    public static final String Path = "/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/module2/data/products.csv";
    List<Product> productList = new ArrayList<>();
    static Scanner scanner;
    public ProductService(){
        productList = IOFIle.read(Path);
    }
    @Override
    public void add(int num) {
        scanner = new Scanner(System.in);
        String regexPrice = "[0-9]{4,}";
        String regexPlace = "[a-zA-Z]{3,}";

        String[] productProperty = productProperty();
        String code ;
        String name = productProperty[1];
        String price = productProperty[2];
        String quantity = productProperty[3];
        String producer = productProperty[4];

        if(num == 1){
            code = "IP"+productProperty[0];
            String priceImport ;
            String provinceImport;
            Double taxImport;

            System.out.println("vui lòng nhập giá nhập khẩu");
            do{
                priceImport = scanner.nextLine();
                if(!priceImport.matches(regexPrice)){
                    System.out.println("giá phải là số dương gồm 4 chữ số");
                    continue;
                }
                break;
            }while(true);


            System.out.println("vui lòng tỉnh thành nhập");
            do{
                provinceImport = scanner.nextLine();
                if(!provinceImport.matches(regexPlace)){
                    System.out.println("tỉnh thành phải là các chữ cái");
                    continue;
                }
                break;
            }while(true);

            System.out.println("Vui lòng nhập giá thuế");
            do{
                try{
                    taxImport = Double.parseDouble(scanner.nextLine());
                    if(taxImport< 0 ){
                        System.out.println("giá thuế phải là số dương");
                        continue;
                    }
                }catch (Exception e){
                    System.out.println("giá thuế phải là số dương");
                    continue;

                }

                break;
            }while(true);

            //String productCode, String name, int price, int quantity, String producer,
            //                         int priceImport, String provinceImport, double taxImport)
            Product importProduct = new ImportProduct(code,name,Integer.parseInt(price),Integer.parseInt(quantity),
                    producer,Integer.parseInt(priceImport),provinceImport,taxImport);

            productList.add(importProduct);
            System.out.println("them thanh cong");
            IOFIle.write("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/module2/data/products.csv",productList);
        }else {
            code = "EP"+productProperty[0];
            String priceExport;
            String countryExport;

            System.out.println("vui lòng nhập giá xuất khẩu");
            do{
                priceExport = scanner.nextLine();
                if(!priceExport.matches(regexPrice)){
                    System.out.println("giá phải là số dương gồm 4 chữ số");
                    continue;
                }
                break;
            }while(true);


            System.out.println("vui lòng nhập nước xuất khẩu");
            do{
                countryExport = scanner.nextLine();
                if(!countryExport.matches(regexPlace)){
                    System.out.println("tỉnh thành phải là các chữ cái");
                    continue;
                }
                break;
            }while(true);

            //String productCode, String name, int price, int quantity,
            //String producer, int priceExport, String countryExport
            //ImportProduct(code,name,Integer.parseInt(price),Integer.parseInt(quantity),
            //                    producer,Integer.parseInt(priceImport),provinceImport,taxImport);
            Product exportProduct = new ExportProduct(code,name,Integer.parseInt(price),Integer.parseInt(quantity),
                    producer,Integer.parseInt(priceExport),countryExport);
            productList.add(exportProduct);
            System.out.println("them thanh cong");
            IOFIle.write("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/module2/data/products.csv",productList);
        }
    }

    @Override
    public void search() {
        scanner = new Scanner(System.in);
        int num;
        System.out.println("1. tim kiem theo ten");
        System.out.println("2. tim kiem theo ma");
        do {
            try{
                System.out.println("vui long nhap so 1 hoac 2");
                num = Integer.parseInt(scanner.nextLine());
                if(num!=1&&num!=2){
                    continue;
                }
            }catch (Exception e){
                System.out.println("vui long nhap so");
                continue;
            }
            break;
        }while(true);
        if(num == 1){
            System.out.println("nhap ten");
            String name = scanner.nextLine();
            boolean check = false;
            for (Product product:productList){
                if(product.getName().toLowerCase().contains(name.toLowerCase())){
                    System.out.println(product);
                    check = true;
                    break;
                }
            }
            if(!check){
                System.out.println("khong co ten san pham nay");
            }
        }else{
            System.out.println("nhap code");
            String code = scanner.nextLine();
            boolean check = false;
            for (Product product:productList){
                if(product.getProductCode().toLowerCase().contains(code.toLowerCase())){
                    System.out.println(product);
                    check = true;
                    break;
                }
            }
            if(!check){
                System.out.println("khong co ma san pham nay");
            }
        }
    }

    @Override
    public void delete() {
        scanner = new Scanner(System.in);
        System.out.println("xoa san pham");
        System.out.println();
        System.out.println("nhap code san pham");
        String code = scanner.nextLine();
        for(Product product:productList){
            if(product.getProductCode().toLowerCase().contains(code.toLowerCase())){
                System.out.println("yes or no");
                String ans = scanner.nextLine();
                if(ans.equals("yes")){
                    productList.remove(product);
                    IOFIle.write("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/module2/data/products.csv",productList);
                    System.out.println("xoa thanh cong");
                    display();
                }

            }else{
                try {
                    throw new NotFoundProductException();
                } catch (NotFoundProductException e) {
                    e.displayException();
                }
            }
        }
    }

    @Override
    public void display() {
        if(productList.size()>0){
            for(Product product : productList){
                System.out.println(product);
            }
        }else{
            System.out.println("danh sach rong");
        }

    }

    String[] productProperty(){
        scanner = new Scanner(System.in);
        String[] productPropertys = new String[5];
        String regexCode = "[0-9]{4}";
        String regexName = "[a-zA-Z0-9]+";
        String regexPrice = "[0-9]{4,}";
        String regexQuantity = "[0-9]+";
        String regexProducer = "[A-Za-z]+";
        String code;
        String name;
        String price;
        String quantity;
        String producer;


        System.out.println("Vui lòng nhập mã sản phẩm gồm 4 số");
        do {
                code = scanner.nextLine();
                if(!code.matches(regexCode)){
                    System.out.println("sai định dạng,vui lòng nhập lại");
                    continue;
                }
                break;
        }while(true);

        System.out.println("Vui lòng nhập tên sản phẩm");
        do {
            name = scanner.nextLine();
            if(!name.matches(regexName)){
                System.out.println("Tên chỉ bao gồm số và chữ");
                continue;
            }

            break;
        }while(true);

        System.out.println("Vui lòng nhập giá sản phẩm");
        do {
            price = scanner.nextLine();
            if(!price.matches(regexPrice)){
                System.out.println("giá phải là số dương");
                continue;
            }
            break;
        }while(true);

        System.out.println("Vui lòng nhập số lượng sản phẩm");
        do {
            quantity = scanner.nextLine();
            if(!quantity.matches(regexQuantity)){
                System.out.println("giá phải là số dương");
                continue;
            }
            break;
        }while(true);

        System.out.println("Vui lòng nhập nhà sản xuất sản phẩm");
        do {
            producer = scanner.nextLine();
            if(!producer.matches(regexProducer)){
                System.out.println("giá phải là số dương");
                continue;
            }
            break;
        }while(true);


        productPropertys[0] = code;
        productPropertys[1] = name;
        productPropertys[2] = price;
        productPropertys[3] = quantity;
        productPropertys[4] = producer;

        return productPropertys;
    }
}
