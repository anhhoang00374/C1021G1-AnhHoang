package com.example.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rentName;
    private float rentCost;
    @OneToMany(mappedBy = "rentType")
    private List<FuramaService> serviceList;
    public RentType() {
    }

    public RentType(Long id, String rentName, float rentCost) {
        this.id = id;
        this.rentName = rentName;
        this.rentCost = rentCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
