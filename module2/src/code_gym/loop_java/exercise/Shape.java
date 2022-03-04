package code_gym.loop_java.exercise;

import java.util.Scanner;

public class Shape {
    static Scanner sc = new Scanner(System.in);
    static int choice = -1;
    public static void main(String[] args) {

        checkValue();
//        if(choice == 1){
//            drawRectangle();
//        }

    }

    static void checkValue(){
        displayMenu();

        displayMenu();
    }

    static void displayMenu(){
        do{

            do{
                System.out.println("Menu");
                System.out.println("1. Print the rectangle");
                System.out.println("2. Print the square triangle");
                System.out.println("3. Print isosceles triangle");
                System.out.println("4. Exit");
                choice = sc.nextInt();
                if(choice == 1){
                    drawRectangle();
                }else if(choice == 2){
                    drawTriangel();
                }else if(choice == 3){
                    System.out.println("input width");
                    int width = sc.nextInt();
                    drawIsoscelesTriangle(width);
                }
            }while(choice>5 || choice<1);
        }while (choice!=0);

    }



    static void drawRectangle(){
        System.out.println("input width of rectangle");
        int width = sc.nextInt();

        System.out.println("input height of rectangle");
        int height = sc.nextInt();
        for(int i = 0;i<height;i++){
            for(int j = 0;j<width;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawTriangel(){
        int position = checkCorner();
        System.out.println("input width of triangle");
        int width = sc.nextInt();
        if(position == 1){
            drawTriangleTopLeft(width);
        }else if(position == 2){
            drawTriangleTopRight(width);
        }else if(position == 3){
            drawTriangleBottomLeft(width);
        }else if(position==4){
            drawTriangleBottomRight(width);
        }
    }

    static int checkCorner(){
        int position;
        do {
            System.out.println("Menu");
            System.out.println("1. position is top-left");
            System.out.println("2. position is top-right");
            System.out.println("3. position is bottom-right");
            System.out.println("4. position is bottom-left");
            position = sc.nextInt();
        }while(position<1 || position>4);
        return position;
    }

    static void drawTriangleTopLeft(int width){
        for(int i = 0;i<width;i++){
            for(int j = 0;j<width-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawTriangleTopRight(int width){
        for(int i = 0;i<width;i++){
            for(int k =0;k<=i;k++){
                System.out.print(" ");
            }
            for(int j = 0;j<width-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawTriangleBottomLeft(int width){
        for(int i = 0;i<=width;i++){
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawTriangleBottomRight(int width){
        for(int i = 0;i<width;i++){
            for(int j = 0;j<width-i;j++){
                System.out.print(" ");
            }
            for(int k =0;k<=i;k++){
                System.out.print("*");
            }

            System.out.println();
        }
    }


    static void drawIsoscelesTriangle(int width){
        int length = 2*width-1;
        for(int i = 0;i<width;i++){
            for(int j = 0;j<length;j++){
                if(j<(length-2*i)/2+1){
                    System.out.print(" ");
                }else if(j<(length-(2*i+1))/2+2*i){
                        System.out.print("*");

                }else  System.out.print(" ");
            }
            System.out.println();
        }
    }
}
