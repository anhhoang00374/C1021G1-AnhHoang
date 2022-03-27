package com.example.case_study.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contractStartDate;
    private String contractEndDate;
    private Float contractDeposit;
    private Float contractTotalMoney;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "service_id",referencedColumnName = "id")
    private FuramaService furamaService;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public FuramaService getFuramaService() {
        return furamaService;
    }

    public void setFuramaService(FuramaService furamaService) {
        this.furamaService = furamaService;
    }

    public Contract() {

    }

    public Contract(String contractStartDate, String contractEndDate, Float contractDeposit,
                    Float contractTotalMoney,
                    Employee employee, Customer customer, FuramaService furamaService) {
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.furamaService = furamaService;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Float getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Float contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Float getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Float contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

}
