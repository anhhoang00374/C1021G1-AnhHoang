package code_gym.array_method.exercise;

import java.util.Scanner;

public class ConcatArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập độ dài mảng thứ nhất");
        int length1 = sc.nextInt();
        int[] intArray1 = new int[length1];
        for(int i = 0;i<length1;i++){
            System.out.println("nhập vào giá trị phần tử thứ "+(i+1)+"của mảng thứ nhất");
            intArray1[i] = sc.nextInt();
        }

        System.out.println("nhập độ dài mảng thứ nhất");
        int length2 = sc.nextInt();
        int[] intArray2 = new int[length2];
        for(int i = 0;i<length1;i++){
            System.out.println("nhập vào giá trị phần tử thứ "+(i+1)+"của mảng thứ hai");
            intArray2[i] = sc.nextInt();
        }
        int[] intArray3 = new int[length1+length2];

        for (int i = 0;i<length1;i++){
                intArray3[i]= intArray1[i];
        }
        for(int i = 0;i<length2;i++){
            intArray3[length1+i]=intArray2[i];
        }

        System.out.println("mang1");
        for(int value : intArray1){
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println("mang2");
        for(int value : intArray2){
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println("mang3");
        for(int value : intArray3){
            System.out.print(value + " ");
        }
    }
}
