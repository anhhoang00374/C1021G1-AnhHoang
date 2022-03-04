package code_gym.algorithm_search.exercise;

import java.util.Scanner;

public class CharacterOfValueUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào chuổi");
        String str = sc.next();
        String result = "";
        int code = (int) str.charAt(0);
        for(int i = 0;i<str.length();i++){
            int currentCode = (int) str.charAt(i);
            if(code<=currentCode){
                code = currentCode;
                result += String.valueOf(str.charAt(i));
            }
        }
        System.out.println(result);
    }
}
