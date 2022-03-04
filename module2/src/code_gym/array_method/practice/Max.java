package code_gym.array_method.practice;

import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int[] arrayInt;

        do {
            System.out.println("vui lòng nhập vào kích thước mảng");
            size = sc.nextInt();
        }while (size<0||size>20);

        arrayInt = new int[size];

        for(int i = 0;i< arrayInt.length;i++){
            System.out.println("vui lòng nhập vào giá trị thứ "+(i+1));
            arrayInt[i] = sc.nextInt();
        }

        int max = arrayInt[0];
        for(int value : arrayInt){
            System.out.println("mảng đã nhập là "+ value);
            if(max<value){
                max = value;
            }
        }

        System.out.println("giá trị lớn nhất là: " + max);


    }
}
