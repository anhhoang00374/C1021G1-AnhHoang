package com.example.case_study.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float salary;
    private String code;
    private String name;
    private String birthday;
    private String phone;
    private String idCard;
    private String address;
    private String email;

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    @JsonBackReference
    private Position position;

    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    @JsonBackReference
    private Division division;

    @ManyToOne
    @JoinColumn(name = "education_id",referencedColumnName = "id")
    @JsonBackReference
    private Education education;

    @OneToOne
    @JoinColumn(name = "user_name",referencedColumnName = "userName")
    private User user;

    public Employee() {

    }


    public Employee(Long id, float salary, String code, String name, String birthday,
                    String phone, String idCard, String address, String email, Position position,
                    Division division, Education education, User user) {
        this.id = id;
        this.salary = salary;
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.idCard = idCard;
        this.address = address;
        this.email = email;
        this.position = position;
        this.division = division;
        this.education = education;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
}
