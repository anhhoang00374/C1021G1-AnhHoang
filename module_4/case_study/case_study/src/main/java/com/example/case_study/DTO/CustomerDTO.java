package com.example.case_study.DTO;

public class CustomerDTO {
    private boolean gender;
    private String code;
    private String name;
    private String birthday;
    private String phone;
    private String idCard;
    private String address;
    private String email;
    private Long customerTypeId;

    public CustomerDTO() {
    }

    public CustomerDTO(boolean gender, String code, String name, String birthday,
                       String phone, String idCard, String address, String email, Long customerType) {
        this.gender = gender;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.idCard = idCard;
        this.address = address;
        this.email = email;
        this.customerTypeId = customerType;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }
}
