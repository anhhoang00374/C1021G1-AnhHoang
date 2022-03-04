package code_gym.array_method.exercise;

import java.util.Scanner;

public class Min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào chiều dài mảng hai chiều");
        int width = sc.nextInt();
        System.out.println("nhập vào chiều rộng mảng hai chiều");
        int height = sc.nextInt();
        int[][] intArray = new int[height][width];
        int min = intArray[0][0];
        for(int i = 0 ;i<height;i++){
            for(int j = 0;j<width;j++){
                System.out.println("nhập vào giá trị của ["+i+"]["+j+"]");
                intArray[i][j] = sc.nextInt();
                if(min>intArray[i][j]){
                    min = intArray[i][j];
                }
            }
        }
        System.out.println("giá trị nhỏ nhất của mảng hai chiều đã nhập là " +min);
    }

}
