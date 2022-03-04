package code_gym.loop_java.practice;

import java.util.Scanner;

public class InteresRate {
    public static void main(String[] args) {
        int month;
        double money;
        double interestRate;
        Scanner sc = new Scanner(System.in);

        System.out.println("input month");
        month = sc.nextInt();
        System.out.println("input money");
        money = sc.nextDouble();
        System.out.println("input interest rate");
        interestRate = sc.nextDouble();

        double total_interest_rate = 0.0d;
        for(int i = 0; i< month;i++){
            total_interest_rate += money*(interestRate/100)/12*month;
        }
        System.out.println("total of interest" + total_interest_rate);

    }
}
