package model;

import model.abstract_class.Person;

public class Customer extends Person implements Comparable<Customer> {
    private int index;
    private static int autoIndex = 0;
    private String customerType;
    private boolean gender;
    private int customerTypeId;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static int getAutoIndex() {
        return autoIndex;
    }

    public static void setAutoIndex(int autoIndex) {
        Customer.autoIndex = autoIndex;
    }

    public boolean isGender() {
        return gender;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public Customer() {
        autoIndex++;
        this.index = autoIndex;
    }

    public Customer(int id, String code, String name, String birthday, String phone, String id_card,
                    String address, String email, String customerType, boolean gender, int customer_type_id) {
        super(id, code, name, birthday, phone, id_card, address, email);
        this.customerType = customerType;
        this.gender = gender;
        this.customerTypeId = customer_type_id;
        autoIndex++;
        this.index = autoIndex;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getCustomer_id() {
        return customerTypeId;
    }

    public void setCustomer_id(int customer_id) {
        this.customerTypeId = customer_id;
    }

    public static void setAutoId(){
        autoIndex = 0;
    }





    @Override
    public int compareTo(Customer o) {
        return this.getCode().compareTo(o.getCode());
    }
}


