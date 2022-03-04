package code_gym.loop_java.practice;

import java.util.Scanner;

public class Shape {
    static Scanner sc = new Scanner(System.in);
    static int choice = -1;
    public static void main(String[] args) {
       checkValue();

        do{
            if(choice == 0){
                break;
            }

            if(choice == 1){
                drawTriangle();
            }

            if(choice == 2){
                drawSquare();
            }

            if(choice == 3){
                drawRectangle();
            }
            checkValue();
        }while (choice!=0);

    }

    static void checkValue(){
        do{
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

        }while(choice > 3 || choice <0);
    }

    static void drawTriangle(){
        System.out.println("input height of triangle");
        int height = sc.nextInt();
        for(int i = height;i > 0;i--){
            for(int j = 0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    static void drawRectangle(){
        System.out.println("input height of rectangle");
        int height = sc.nextInt();
        System.out.println("input height of rectangle");
        int width = sc.nextInt();
        for(int i =0;i <height;i++){
            for(int j = 0;j<width;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawSquare(){
        System.out.println("input height of square");
        int height = sc.nextInt();
        for(int i =0;i <height;i++){
            for(int j = 0;j<height;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
