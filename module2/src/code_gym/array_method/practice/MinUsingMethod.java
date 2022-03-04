package code_gym.array_method.practice;

import java.util.Scanner;

public class MinUsingMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrInt;
        System.out.println("nhập vào kích thước mảng");
        int size = sc.nextInt();
        arrInt = new int[size];

        for(int i = 0;i<size;i++){
            System.out.println("nhập vào giá trị phần từ "+(i+1));
            arrInt[i] = sc.nextInt();
        }

        System.out.println("Giá tri  nhỏ nhất của mảng đã nhập là "+min(arrInt));
    }
    static int min(int[] arr){
        int min = arr[0];
        for (int i = 1;i < arr.length;i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        return  min;
    }
}

