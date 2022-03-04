package code_gym.array_method.exercise;

import java.util.Scanner;

public class SumOfDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào độ dài mảng hai chiều");
        int width = sc.nextInt();
        int[][] intArray = new int[width][width];
        int sumOfDiagonal = 0;
        for(int i = 0;i<width;i++){
            for(int j = 0;j<width;j++){
                System.out.println("Nhập vào giá trị của ["+i+"]["+j+"]");
                intArray[i][j] = sc.nextInt();
                if(j==i){
                    sumOfDiagonal += intArray[i][j];
                }
            }
        }
        System.out.println("giá trị cần tìm là " + sumOfDiagonal);

    }
}
