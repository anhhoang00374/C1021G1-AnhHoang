package code_gym.algorithm_sort.exercise;

import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào kích thước mảng");
        int size = sc.nextInt();
        int[] arrInt = new int[size];
        for(int i = 0;i < arrInt.length;i++){
            System.out.println("nhập vào giá trị thứ "+(i+1));
            arrInt[i] = sc.nextInt();
        }
        System.out.println("mảng trước khi sắp xếp là");
        for(int value : arrInt){
            System.out.print(value + " ");
        }
        System.out.println();
        Sort.insertSort(arrInt);
        System.out.println("mảng sau khi sắp xếp là");
        for(int value : arrInt){
            System.out.print(value + " ");
        }
    }


}
