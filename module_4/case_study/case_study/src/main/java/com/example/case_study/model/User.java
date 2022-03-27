package com.example.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String userName;
    private String password;
    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Employee employee;

    @ManyToMany(mappedBy = "userList",fetch = FetchType.EAGER)
    private Set<Role> roleList;
    public Employee getEmployee() {
        return employee;
    }

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User() {

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
