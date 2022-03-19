package com.example.case_study.model;

public class AttachService {
    private int attachServiceId;
    private String attachServiceName;
    private int attachServiceCost;
    private String attachServiceUnit;
    private int attachServiceNumbers;
    private String serviceStatusStatus;

    public AttachService() {
    }

    public AttachService(int attach_service_id, String attach_service_name, int attach_service_cost,
                         String attach_unit, int attach_service_numbers, String service_status_status) {
        this.attachServiceId = attach_service_id;
        this.attachServiceName = attach_service_name;
        this.attachServiceCost = attach_service_cost;
        this.attachServiceUnit = attach_unit;
        this.attachServiceNumbers = attach_service_numbers;
        this.serviceStatusStatus = service_status_status;
    }

    public int getAttachServiceNumbers() {
        return attachServiceNumbers;
    }

    public void setAttachServiceNumbers(int attachServiceNumbers) {
        this.attachServiceNumbers = attachServiceNumbers;
    }

    public int getAttach_service_id() {
        return attachServiceId;
    }

    public void setAttach_service_id(int attach_service_id) {
        this.attachServiceId = attach_service_id;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public int getAttach_service_cost() {
        return attachServiceCost;
    }

    public void setAttach_service_cost(int attach_service_cost) {
        this.attachServiceCost = attach_service_cost;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getServiceStatusStatus() {
        return serviceStatusStatus;
    }

    public void setServiceStatusStatus(String serviceStatusStatus) {
        this.serviceStatusStatus = serviceStatusStatus;
    }
}
