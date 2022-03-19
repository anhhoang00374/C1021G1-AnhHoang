package util;

import model.Customer;

import java.util.HashMap;

public class ValidationCustomer {
    private  static final String CHECK_PHONE = "(\\(84\\)\\+90[0-9]{7})|(\\(84\\)\\+91[0-9]{7})|(090[0-9]{7})|(091[0-9]{7})";
    private static final String CHECK_ID_CARD = "([0-9]{9})|([0-9]{12})";
    public static HashMap<String,String> checkMap(Customer customer){
        HashMap<String,String> checkList = new HashMap<>();
        if(customer.getPhone()==null||!customer.getPhone().matches(CHECK_PHONE)){
            checkList.put("phone","Số điện thoại không hượp lệ");
        }

        if(customer.getId_card()==null||!customer.getId_card().matches(CHECK_ID_CARD)){
            checkList.put("idCard","Số chừng minh không hợp lệ");
        }
        if(customer.getName()==null){
            checkList.put("idCard","");
        }
        if(customer.getBirthday()==null){
            checkList.put("birthday","");
        }

        if(customer.getAddress()==null){
            checkList.put("address","");
        }
        if(customer.getAddress()==null){
            checkList.put("email","");
        }
        return checkList;
    }
}
