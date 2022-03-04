package test.codegymController;

import test.codegymService.PersonService;

import java.util.Scanner;

public class CodeGymController {
    static Scanner scanner;
    static PersonService personService = new PersonService();
    public static void main(String[] args) {
        run();
    }

    static void run(){
        scanner = new Scanner(System.in);
        int choice;

       do{

           System.out.println();
           System.out.println();
           System.out.println("-CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN--");
           System.out.println();
           System.out.println("Chọn chức năng theo số (để tiếp tuc):");
           System.out.println();
           System.out.println("1. Thêm mới giảng viên hoặc học sinh");
           System.out.println("2. Xoa học sinh hoặc giảng viên");
           System.out.println("3. Xem danh sách giảng viên hoặc học sinh");
           System.out.println("4. Tìm kiếm giảng viên hoặc hoặc sinh");
           System.out.println("5. Thoát");
           System.out.println("Chọn chức năng");
           try {
               choice = Integer.parseInt(scanner.nextLine());
           }catch(Exception e){
               System.out.println("vui lòng nhập một số");
                continue;
           }
           switch (choice){
               case 1:
                   add();
                   break;
               case 2:
                   delete();
                   break;
               case 3:
                   display();
                   break;
               case 4:
                   search();
                   break;
               case 5:
                   System.exit(0);
                   break;
               default:
                   System.out.println("vui lòng chọn số từ 1 đến 6");
                   continue;
           }
           break;
       }while(true);


    }


    static  void add(){
        int choice = 0;
        scanner = new Scanner(System.in);
        do{
            System.out.println();
            System.out.println("Thêm một thành viên mới");
            System.out.println();
            System.out.println("1. Thêm một học viên");
            System.out.println("2. Thêm một giảng viên");
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập một số");
            }

            switch (choice){
                case 1:
                    personService.add(1);
                    run();
                    break;
                case 2:
                    personService.add(2);
                    run();
                    break;
                default:
                    System.out.println("vui lòng chọn số từ 1 đến 2");
                    continue;
            }
            break;
        }while(true);

    }


    static  void delete(){
        int choice = 0;
        scanner = new Scanner(System.in);
        do{
            System.out.println();
            System.out.println("Xoá thành viên");
            System.out.println();
            System.out.println("1. Xoá một học sinh");
            System.out.println("2. Xoá một giảng viên");
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập một số");
            }

            switch (choice){
                case 1:
                    personService.delete(1);
                    run();
                    break;
                case 2:
                    personService.delete(2);
                    run();
                    break;
                default:
                    System.out.println("vui lòng chọn số từ 1 đến 2");
                    continue;
            }
            break;
        }while(true);

    }

    static  void display(){
        int choice = 0;
        scanner = new Scanner(System.in);
        do{
            System.out.println();
            System.out.println("Hiển thị danh sách thành viên");
            System.out.println();
            System.out.println("1. Hiển thị danh sách học viên");
            System.out.println("2. Hiển thị danh sách giảng viên");

            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập một số");
            }

            switch (choice){
                case 1:
                    personService.display(1);

                    run();
                    break;
                case 2:
                    personService.display(2);
                    run();
                    break;
                default:
                    System.out.println("vui lòng chọn số từ 1 đến 2");
                    continue;
            }
            break;
        }while(true);
        
    }

    static  void search(){
        personService.search();
    }

}
