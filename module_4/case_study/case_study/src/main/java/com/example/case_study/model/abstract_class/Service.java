package com.example.case_study.model.abstract_class;

public abstract class Service {
    private int id_service;
    private String code;
    private String serviceName;
    private float serviceArea;
    private float serviceCost;
    private int serviceMaxPeople;
    private String rent_type;
    private float rent_cost;
    private int serviceTypeId;
    private String serviceTypeName;
    private int rentTypeId;



    public Service() {
    }

    public Service(int id_service, String code, String serviceName, float serviceArea, float serviceCost,
                   int serviceMaxPeople, String rent_type,
                   float rent_cost, int serviceTypeId, String serviceTypeName, int rentTypeId) {
        this.id_service = id_service;
        this.code = code;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rent_type = rent_type;
        this.rent_cost = rent_cost;
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.rentTypeId = rentTypeId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(float serviceArea) {
        this.serviceArea = serviceArea;
    }

    public float getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(float serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getRent_type() {
        return rent_type;
    }

    public void setRent_type(String rent_type) {
        this.rent_type = rent_type;
    }

    public float getRent_cost() {
        return rent_cost;
    }

    public void setRent_cost(float rent_cost) {
        this.rent_cost = rent_cost;
    }
}
