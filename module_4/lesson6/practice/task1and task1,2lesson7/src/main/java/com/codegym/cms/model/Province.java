package com.codegym.cms.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long province_id;
    private String name;

    @OneToMany(mappedBy = "province")
    private List<Customer> customerList;

    public Province() {
    }

    public Province(Long id, String name, List<Customer> customerList) {
        this.province_id = id;
        this.name = name;
        this.customerList = customerList;
    }

    public Long getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Long id) {
        this.province_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}