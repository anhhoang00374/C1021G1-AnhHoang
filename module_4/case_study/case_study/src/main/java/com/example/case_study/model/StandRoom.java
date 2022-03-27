package com.example.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class StandRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String standRoomName;
    @OneToMany(mappedBy = "standRoom",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<FuramaService> serviceList;

    public StandRoom(String standRoomName) {
        this.standRoomName = standRoomName;
    }

    public StandRoom() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStandRoomName() {
        return standRoomName;
    }

    public void setStandRoomName(String standRoomName) {
        this.standRoomName = standRoomName;
    }
}
