package code_gym.loop_java.exercise;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vào số lượng số nguyên số muốn in ra");
        int quantity = sc.nextInt();
        int currentQuantity = 0;
        //boolean isPrime = false;
        int number = 1;
        while (currentQuantity<quantity){
            int count = 0;
            number++;
            for(int i = 1;i<=number;i++){
                if(number%i == 0 ){
                    count++;
                }
            }
            if(count == 2){
                System.out.print(number+",");
                currentQuantity++;
            }
        }
    }

}
