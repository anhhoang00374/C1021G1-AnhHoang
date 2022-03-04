package code_gym.array_method.practice;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập tên bạn muốn tìm kiếm");
        String inputName = sc.nextLine();

        boolean isExist = false;
        for(String name : students){
            if(name.equals(inputName)){
                isExist = true;
                break;
            }
        }

        if(isExist){
            System.out.println(inputName + " có tồn tại");
        }else System.out.println(inputName + " không tồn tại");
    }
}
