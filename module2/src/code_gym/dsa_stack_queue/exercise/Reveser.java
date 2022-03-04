package code_gym.dsa_stack_queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class Reveser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vui lòng nhập vào chuỗi");
        String str = sc.nextLine();
        System.out.println(reveserString(str));

        System.out.println("nhập vào số phần tử mảng");
        int length = sc.nextInt();
        int[] arr = new int[length];
        for(int i = 0;i<length;i++){
            System.out.println("nhập vào giá trị thứ "+(i+1));
            arr[i] = sc.nextInt();
        }

        System.out.println("mảng đã nhập là");
        for(int value : arr){
            System.out.print(value+ " ");
        }

        System.out.println();
        System.out.println("mảng sau khi đảo là");
        int[] intArray = reverserIntArray(arr);
        for(int value : intArray){
            System.out.print(value+ " ");
        }

    }
    static String reveserString(String str){
        String reveserStr = "";
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<str.length();i++){
            stack.push(str.charAt(i));
        }

        for(int i = 0;i<str.length();i++){
            reveserStr += stack.pop();
        }
        return reveserStr;
    }

    static int[] reverserIntArray(int[] arr){
        int[] intArr = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int value : arr){
            stack.push(value);
        }
        for(int i = 0;i<arr.length;i++){
            intArr[i] = stack.pop();
        }
        return intArr;
    }
}
