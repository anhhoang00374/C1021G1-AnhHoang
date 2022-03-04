package code_gym.loop_java.practice;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("please input number that you want to check");
        int number = sc.nextInt();

        if(isPrime(number)){
            System.out.println("this is a prime number");
        }else System.out.println("this isn't a prime number");
    }


    public  static boolean isPrime(int num){
        if(num<2){
            return false;
        }else if(num==2){
            return true;
        }else{
            int decreNum = 3;
            while(decreNum < Math.sqrt(num)){
                if(num%decreNum==0){
                    System.out.println(decreNum);
                    return false;

                }
                decreNum++;
            }
        }
        return true;
    }
}
