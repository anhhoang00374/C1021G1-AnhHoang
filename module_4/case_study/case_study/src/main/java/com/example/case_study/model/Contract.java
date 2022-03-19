package com.example.case_study.model;


import com.example.case_study.model.ContractDetail;

import java.util.List;

public class Contract {
    private int contractId;
    private String contractStartDate;
    private String contractEndDate;
    private float contractDeposit;
    private float contractTotalMoney;
    private String employeeName;
    private String customerName;
    private String serviceName;
    private int employeeId;
    private int customerId;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    private int serviceId;
    private List<ContractDetail> listAttachService;

    public Contract() {
    }

    public Contract(int contractId, String contractStartDate, String contractEndDate, float contractDeposit, float contractTotalMoney,
                    String employeeName, String customerName, String serviceName,
                    int employeeId, int customerId, int serviceId, List<ContractDetail> listAttachService) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.serviceName = serviceName;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.listAttachService = listAttachService;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
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

    public float getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(float contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public float getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(float contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public List<ContractDetail> getListAttachService() {
        return listAttachService;
    }

    public void setListAttachService(List<ContractDetail> listAttachService) {
        this.listAttachService = listAttachService;
    }
}
