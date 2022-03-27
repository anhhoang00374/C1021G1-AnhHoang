package com.example.case_study.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attachServiceName;
    private int attachServiceCost;
    private String attachServiceUnit;
    private int attachServiceNumbers;
    private String serviceStatusStatus;

    public AttachService() {
    }

    public AttachService(Long attach_service_id, String attach_service_name, int attach_service_cost,
                         String attach_unit, int attach_service_numbers, String service_status_status) {
        this.id = attach_service_id;
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

    public Long getAttach_service_id() {
        return id;
    }

    public void setAttach_service_id(Long attach_service_id) {
        this.id = attach_service_id;
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
