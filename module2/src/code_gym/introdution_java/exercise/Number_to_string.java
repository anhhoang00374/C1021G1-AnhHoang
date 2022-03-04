package code_gym.introdution_java.exercise;

import java.util.Scanner;

public class Number_to_string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Number_to_string numObj = new Number_to_string();
        int num;
        String result = "";

        do {
            System.out.println("please enter num");
            num = sc.nextInt();
        }while (numObj.checkValue(num));

        if(num<=10){
            result += numObj.lessTen(num,result);
        }else if(num<20){
            result += numObj.lessTwenty(num,result);
        }else if(num<100){
            result += numObj.lessHundred(num,result);
            int tens = num/10;
            int units = num -(num/10)*10;
            result = numObj.lessTen(units,result);
        }else{
            result += numObj.lessThousand(num,result,numObj);
        }

        System.out.println(result);

    }




    public boolean checkValue(int num){
        if(num<0 ||num>999){
            return true;
        }
        return false;
    }

    public String lessTen(int num,String content){
        switch (num){
            case 0:
                content += "zero";
                break;
            case 1:
                content += "one ";
                break;
            case 2:
                content += "two ";
                break;
            case 3 :
                content += "three ";
                break;
            case 4:
                content += "four ";
                break;
            case 5:
                content += "five ";
                break;
            case 6:
                content += "six ";
                break;
            case 7 :
                content += "seven ";
                break;
            case 8:
                content += "eight ";
                break;
            case 9:
                content += "nine ";
                break;
            case 10:
                content += "ten ";
                break;
        }
        return content;
    }

    public String lessTwenty(int num,String content){
        switch (num){
            case 11:
                content += "eleven ";
                break;
            case 12:
                content += "twelve ";
                break;
            case 13:
                content += "thirteen ";
                break;
            case 14 :
                content += "fourteen ";
                break;
            case 15:
                content += "fifteen ";
                break;
            case 16:
                content += "sixteen ";
                break;
            case 17:
                content += "seventeen ";
                break;
            case 18 :
                content += "eighteen ";
                break;
            case 19:
                content += "nineteen ";
                break;
        }
        return content;
    }

    public String lessHundred(int num,String content){
        int tens = num/10;
        int units = num -(num/10)*10;
        switch (tens){
            case 2:
                content += "twenty ";
                break;
            case 3:
                content += "thirty ";
                break;
            case 4:
                content += "forty ";
                break;
            case 5 :
                content += "fifty ";
                break;
            case 6:
                content += "sixty ";
                break;
            case 7:
                content += "seventy ";
                break;
            case 8:
                content += "eighty ";
                break;
            case 9 :
                content += "ninety ";
                break;
        }

        return content;
    }

    public String lessThousand(int num,String content, Number_to_string numObj){
        int hundreds = num/100;
        int tens = num - (num/100)*100;
        int units = num - hundreds*100 - (tens/10)*10;

        switch (hundreds){
            case 1:
                content += "one hundred and ";
                break;
            case 2:
                content += "two hundred and ";
                break;
            case 3:
                content += "three hundred and ";
                break;
            case 4 :
                content += "four hundred and ";
                break;
            case 5:
                content += "five hundred and ";
                break;
            case 6:
                content += "six hundred and ";
                break;
            case 7:
                content += "seven hundred and ";
                break;
            case 8 :
                content += "eight hundred and ";
                break;
            case 9 :
                content += "nine hundred and ";
                break;
        }

        if(tens/10>1){
            content = numObj.lessHundred(tens,content);
            if(units>0){
                content = numObj.lessTen(units,content);
            }

        }else if(tens/10==1){
            content = numObj.lessTwenty(tens,content);

        }else content = numObj.lessTen(units,content);

        return content;
    }

}
