package code_gym.introdution_java.practice;

import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        float width;
        float height;
        float area;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter width");
        width = sc.nextFloat();

        System.out.println("Enter height");
        height = sc.nextFloat();

        area = width * height;

        System.out.println("Area is :" + area);
    }
}
