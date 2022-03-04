package code_gym.class_and_object.exercise.quadraticEquation;

import java.util.Scanner;

public class QuadraticEquationTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("giải phương trình bậc hai");
        System.out.println("nhập vào số a");
        double a = sc.nextDouble();
        System.out.println("nhập vào số b");
        double b = sc.nextDouble();
        System.out.println("nhập vào số c");
        double c = sc.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);
        if(quadraticEquation.getDiscriminant()>0){
            System.out.println("phương trình có hai nghiệm là "+ quadraticEquation.getRoot1() +" và "+ quadraticEquation.getRoot2());
        }else if(quadraticEquation.getDiscriminant()==0){
            System.out.println("phương trình có nghiệm là "+ quadraticEquation.getRoot1());
        }else System.out.println("phương trình vô nghiệm");

    }

}
