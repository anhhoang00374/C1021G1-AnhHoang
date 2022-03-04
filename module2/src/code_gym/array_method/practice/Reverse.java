package code_gym.array_method.practice;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrayInt;
        int size = 0;

        do{
            System.out.println("vui lòng nhập kích thước mảng là số nhỏ hơn 20");
            size = sc.nextInt();
        }while(size>20||size<0);

        arrayInt = new int[size];

        for(int i = 0;i<arrayInt.length;i++){
            System.out.println("Vui lòng nhập vào giá trị của phần tử " + (i+1));
            arrayInt[i] = sc.nextInt();
        }
        System.out.println("Mảng trước khi đảo là");
        for(int value:arrayInt){
            System.out.print(value+" ");
        }
        System.out.println();

        System.out.println("Mảng sau khi đảo là");
        for(int i = 0;i<arrayInt.length/2;i++){
           int temp = arrayInt[i];
           arrayInt[i] = arrayInt[arrayInt.length-i-1];
           arrayInt[arrayInt.length-i-1] = temp;
        }

        for(int value:arrayInt){
            System.out.print(value+" ");
        }
        System.out.println();
    }
}
