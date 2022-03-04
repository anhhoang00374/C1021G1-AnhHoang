package module2.Controller;

import module2.service.ProductService;

import java.util.Scanner;

public class MainController {
    static Scanner scanner;
    static ProductService productService = new ProductService();
    public static void main(String[] args) {
        run();
    }

    static void run() {
        scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println();
            System.out.println();
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM--");
            System.out.println();
            System.out.println("Chọn chức năng theo số (để tiếp tuc):");
            System.out.println();
            System.out.println("1. Thêm mới");
            System.out.println("2. Xoá");
            System.out.println("3. Xem danh sách sản phẩm");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.println("Chọn chức năng");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("vui lòng nhập một số");
                continue;
            }
            switch (choice) {
                case 1:
                    BusinessController.add();
                    run();
                    break;
                case 2:
                    BusinessController.delete();
                    run();
                    break;
                case 3:
                    BusinessController.display();
                    run();
                    break;
                case 4:
                    BusinessController.search();
                    run();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng chọn số từ 1 đến 5");
                    continue;
            }
            break;
        } while (true);
    }
}
