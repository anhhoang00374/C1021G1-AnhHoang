package code_gym.array_method.exercise;

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào độ dài của mảng bạn muốn tạo(nhỏ hơn 10)");
        int length = sc.nextInt();
        int[] intArray = new int[10];
        for(int i = 0;i<length;i++){
            System.out.println("Nhập vào giá trị của phần tử thứ "+(i+1));
            intArray[i] = sc.nextInt();
        }

        System.out.println("Nhập vào vị trí index bạn muốn thêm phần tử");
        int position = sc.nextInt();

        System.out.println("Nhập vào giá trị bạn muốn thêm");
        int value = sc.nextInt();

        System.out.println("mảng trước khi chèn là");
        for (int v:intArray) {
            if(v!=0){
                System.out.print(v+" ");
            }

        }
        System.out.println();

        for(int i = length;i>position;i--){
            intArray[i] = intArray[i-1];
        }
        intArray[position]= value;

        System.out.println("mảng sau khi chèn là");
        for(int v : intArray){
            if(v!=0){
                System.out.print(v+" ");
            }

        }
    }
}
