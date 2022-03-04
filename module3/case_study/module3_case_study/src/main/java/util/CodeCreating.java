package util;

public class CodeCreating {
    public static String setCode(String type, int code){
        if(code<10){
            return type+"000"+code;
        }else if(code<100){
            return type+"00"+code;
        }else if(code<1000){
            return type+"0"+code;
        }else return type+code;
    }
}
