package code_gym.string_regex.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    public static void main(String[] args) {
        final String regex = "\\(84\\)-\\(0[0-9]{8}\\)";
        Pattern pattern = Pattern.compile(regex);
        Scanner scanner = new Scanner(System.in);
        System.out.println("input data");
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            System.out.println("true");
        }else System.out.println(false);
    }
}
