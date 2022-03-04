package code_gym.introdution_java.exercise;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double RATE = 23000d;

        double usd = sc.nextDouble();
        double vnd = RATE*usd;

        System.out.printf("%.0f USD = %.0f VND",usd,vnd);

    }
}
