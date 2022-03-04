package code_gym.java_collection_framework.exercise.manager.controller;

import code_gym.java_collection_framework.exercise.manager.model.ProductManager;
import code_gym.java_collection_framework.exercise.manager.service.ProductManagerService;

import java.util.Scanner;

public class ProductController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        ProductManagerService productManagerService = new ProductManagerService();

        do{
            System.out.println("Chương trình quản lý sản phẩm");
            System.out.println("1. Nhấn 1 để thêm sản phẩm");
            System.out.println("2. Nhấn 2 để xoá sản phẩm theo id");
            System.out.println("3. Nhấn 3 để tìm kiếm sản phẩm theo tên");
            System.out.println("4. Nhấn 4 để cập nhât sản phẩm theo id");
            System.out.println("5. Nhấn 5 để sắp xếp sản phẩm tăng theo giá");
            System.out.println("6. Nhấn 6 để sắp xếp sản phẩm giảm theo giá");
            System.out.println("7. Nhấn 0 để thoát");
             num = sc.nextInt();
            switch (num){
                case 1:
                    System.out.println("vui lòng nhập tên");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("vui lòng nhập giá");
                    int price = sc.nextInt();
                    productManagerService.add(new ProductManager(name,price));
                    break;
                case 2:
                    System.out.println("vui lòng nhập id của sản phẩm");
                    int id = sc.nextInt();
                    productManagerService.remove(id);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("vui lòng nhập tên sản phẩm");
                    String productName = sc.nextLine();
                    System.out.println(productManagerService.search(productName));

                    break;
                case 4:
                    System.out.println("vui lòng nhập id của sản phẩm");
                    int idUpdate = sc.nextInt();
                    productManagerService.update(idUpdate);
                    break;
                case 5:
                    productManagerService.displayPriceUp();
                    break;
                case 6:
                    productManagerService.displayPriceDown();
            }

        }while (num!=0);

    }
}
