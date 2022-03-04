package code_gym.array_method.exercise;

import java.util.Scanner;

public class QuantityOfChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập chuổi gốc");
        String str = sc.nextLine();
        System.out.println("Vui lòng nhập kí tự muốn tim kiếm");
        //sc.nextLine();
        char charStr = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (charStr == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("số lần xuất hiện của kí tự đã nhập là " + count);
    }
}
