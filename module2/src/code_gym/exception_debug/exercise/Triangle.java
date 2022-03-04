package code_gym.exception_debug.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
    static boolean check = true;
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Scanner sc = new Scanner(System.in);

        while(check){
            check = false;
            int a = 0,b=0,c=0;
            try{
                System.out.println("nhập vào cạnh a");
                a = Integer.parseInt(sc.nextLine());
                System.out.println("nhập vào cạnh b");
                b = Integer.parseInt(sc.nextLine());
                System.out.println("nhập vào cạnh c");
                c = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e){
                check = true;
                continue;
            }
            try{
                triangle.checkValue(a,b,c);
                System.out.println("bạn đã nhập đúng 3 cạnh của một tam giác");
            }catch (IllegalTriangleException e) {
                System.out.println(e.getErr());
                check = true;
            }

        }

        }
        public void checkValue(int a,int b,int c) throws IllegalTriangleException {
            if (a < 0||b<0||b<0){
                throw new IllegalTriangleException("không được nhập số âm");
            }
            if(a+b<=c||b+c<=0||a+c<=b){
                throw new IllegalTriangleException("tổng hai cạnh phải lớn hơn 1 cạnh");
            }
        }

}
