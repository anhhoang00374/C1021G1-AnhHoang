package code_gym.array_method.exercise;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào số hàng");
        int height = sc.nextInt();

        System.out.println("nhập vào số cột");
        int width = sc.nextInt();

        int[][] intArray = new int[height][width];
        for(int i = 0 ;i<height;i++){
            for(int j = 0;j<width;j++){
                System.out.println("nhập vào giá trị tại ["+i+"]["+j+"]");
                intArray[i][j] = sc.nextInt();
            }
        }

        int sumOfHeight;
        int sum = 0;
        do{
            System.out.println("nhập vào hàng bạn muốn tính tổng(nhỏ hơn "+ height+")");
            sumOfHeight = sc.nextInt();
        }while (sumOfHeight>=height);

        for(int i = 0;i<width;i++){
            sum+=intArray[sumOfHeight][i];
        }

        System.out.println("giá trị cần tìm là "+ sum);
    }
}
