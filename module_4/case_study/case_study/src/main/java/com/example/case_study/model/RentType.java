package com.example.case_study.model;

public class RentType {
    private int id;
    private String rentName;
    private float rentCost;

    public RentType() {
    }

    public RentType(int id, String rentName, float rentCost) {
        this.id = id;
        this.rentName = rentName;
        this.rentCost = rentCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public float getRentCost() {
        return rentCost;
    }

    public void setRentCost(float rentCost) {
        this.rentCost = rentCost;
    }
}
