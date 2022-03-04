package code_gym.introdution_java.practice;

import java.util.Scanner;

public class Resolving_equation {
    public static void main(String[] args) {

        double a;
        double b;
        double c;

        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        a = scanner.nextDouble();

        System.out.print("b: ");
        b = scanner.nextDouble();

        System.out.print("c: ");
        c = scanner.nextDouble();

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        }else {
            if (b == c) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
