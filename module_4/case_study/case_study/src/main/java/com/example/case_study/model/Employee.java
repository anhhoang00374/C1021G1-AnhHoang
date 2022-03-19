package com.example.case_study.model;


import com.example.case_study.model.abstract_class.Person;

public class Employee extends Person {
    private static int autoIndex = 0;
    private int index;
    private float salary;
    private String position;
    private String division;
    private String educationDegree;
    private String userName;
    private int position_id;
    private int education_id;
    private int division_id;

    public Employee() {
        autoIndex++;
        this.index = autoIndex;
    }

    public static int getAutoIndex() {
        return autoIndex;
    }

    public static void setAutoIndex(int autoIndex) {
        Employee.autoIndex = autoIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Employee(int id, String code, String name, String birthday,
                    String phone, String id_card, String address, String email, float salary,
                    String position, String division, String educationDegree,
                    String userName, int position_id, int education_id, int division_id) {
        super(id, code, name, birthday, phone, id_card, address, email);
        this.salary = salary;
        this.position = position;
        this.division = division;
        this.educationDegree = educationDegree;
        this.userName = userName;
        this.position_id = position_id;
        this.education_id = education_id;
        this.division_id = division_id;
        autoIndex++;
        this.index = autoIndex;
    }

    public static void reStartAutoIndex(){
        autoIndex = 0;
    }
    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getEducation_id() {
        return education_id;
    }

    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }


}
