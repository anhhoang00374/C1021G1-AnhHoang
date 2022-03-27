package com.example.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Complimentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String complimentaryName;
//    @ManyToMany
//    List<Service>  serviceList;
    public Complimentary() {
    }

    public Complimentary(String complimentaryName) {
        this.complimentaryName = complimentaryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplimentaryName() {
        return complimentaryName;
    }

    public void setComplimentaryName(String complimentaryName) {
        this.complimentaryName = complimentaryName;
    }
}
