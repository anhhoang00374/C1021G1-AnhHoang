package module2.Controller;

import module2.service.ProductService;
import module2.utils.Validation;
import test.model.Person;

import java.util.Scanner;

public class BusinessController {
    static Scanner scanner;
    static int choice;
    static ProductService productService = new ProductService();
    static void add(){
        scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("thêm sàn phẩm");
        do{

            System.out.println();
            System.out.println("1. Thêm sản phẩm nhập khẩu ");
            System.out.println("2. Thêm sản phẩm xuất khẩu");
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập một số");
                continue;
            }

            switch (choice){
                case 1:
                    productService.add(1);
                    break;
                case 2:
                    productService.add(2);
                    break;
                default:
                    System.out.println("vui lòng chọn số từ 1 đến 2");
                    continue;
            }
            break;
        }while(true);
    }
    static void search() {
        productService.search();
    }
    static void edit(){
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        //
    }
    static void display(){
        productService.display();
    }
    static void delete() {
    productService.delete();

    }
}
