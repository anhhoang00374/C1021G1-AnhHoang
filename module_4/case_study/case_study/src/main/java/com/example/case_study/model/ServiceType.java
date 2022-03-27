package com.example.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


import java.util.List;
@Entity
public class ServiceType {
    public List<FuramaService> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<FuramaService> serviceList) {
        this.serviceList = serviceList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String serviceTypeName;
    @OneToMany(mappedBy = "serviceType")
    @JsonBackReference
    private List<FuramaService> serviceList;

    public ServiceType() {
    }

    public ServiceType(Long serviceTypeId, String serviceTypeName) {
        this.id = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long serviceTypeId) {
        this.id = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
