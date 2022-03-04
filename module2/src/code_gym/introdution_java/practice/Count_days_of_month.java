package code_gym.introdution_java.practice;

import java.util.Scanner;

public class Count_days_of_month {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Which month that you want to count days? ");
        int month = sc.nextInt();

        String daysOfMonth;

        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysOfMonth = "this month has 31 days";
                break;
            case 2:
                daysOfMonth = "this month has 28 or 29 days";
            case 4:
            case 6:
            case 9:
            case 11:
                daysOfMonth = "this month has 30 days";
                break;
            default:
                daysOfMonth = "this month hasn't exist";
                break;
        }

        System.out.println(daysOfMonth);

    }
}
