package code_gym.introdution_java.exercise;

import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your name");
        String name = sc.nextLine();
        System.out.printf("Hello %s",name);
    }
}
