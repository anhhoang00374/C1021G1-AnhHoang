package code_gym.array_method.exercise;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào kích thước mảng");
        int size = sc.nextInt();
        int[] arrInt = new int[size];
        int[] deletedArray = new int[size-1];
        int deleteNumber;

        for(int i = 0;i<size;i++){
            System.out.println("Vui lòng nhập vào giá trị thứ "+(i+1));
            arrInt[i] = sc.nextInt();
        }

        System.out.println("Mảng đã nhập là");
        for(int value : arrInt){
            System.out.print(value+" ");
        }

        System.out.println();
        System.out.println("nhập vào phần tử muốn xoá");
        deleteNumber = sc.nextInt();

        for(int i = 0;i<arrInt.length;i++){
            if(arrInt[i]==deleteNumber){
                for(int j = i;j<arrInt.length-1;j++){
                    deletedArray[j] = arrInt[j+1];
                }
                break;
            }
            deletedArray[i] =arrInt[i];
        }

        System.out.println("Mảng sau khi xoá là");
        for(int value : deletedArray){
            System.out.print(value+" ");
        }
    }
}
