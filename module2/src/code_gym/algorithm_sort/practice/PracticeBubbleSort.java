package code_gym.algorithm_sort.practice;

import java.util.Scanner;

public class PracticeBubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào độ dài mảng");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0;i<size;i++){
            System.out.println("nhập vào giá trị phần tử thứ "+(i+1));
            arr[i] = sc.nextInt();
        }

        System.out.println("mảng bạn đã nhập là :");
        for(int value : arr){
            System.out.print(value+ " ");
        }

        System.out.println();
        System.out.println("mảng sau khi sắp xếp là :");
        BubbleSort.bubbleSort(arr);
        for(int value : arr){
            System.out.print(value+ " ");
        }
    }
}
