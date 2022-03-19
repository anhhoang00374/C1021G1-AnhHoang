package com.example.case_study.model;


import com.example.case_study.model.abstract_class.Service;

public class House extends Service {
    private int index;
    private static int autoIndex = 0;
    private String standard_room;
    private String description_other_convenience;
    private int number_of_floors;

    public House() {
        this.autoIndex ++;
        this.index = autoIndex;
    }

    public House(int id_service, String code, String serviceName, float serviceArea,
                 float serviceCost, int serviceMaxPeople, String rent_type, float rent_cost,
                 int serviceTypeId, String serviceTypeName, int rentTypeId, String standard_room,
                 String description_other_convenience, int number_of_floors) {
        super(id_service, code, serviceName, serviceArea, serviceCost, serviceMaxPeople, rent_type, rent_cost, serviceTypeId, serviceTypeName, rentTypeId);
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.number_of_floors = number_of_floors;
        this.autoIndex ++;
        this.index = autoIndex;
    }

    public static void restartIndexAuto(){
        autoIndex = 0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getAutoIndex() {
        return autoIndex;
    }

    public void setAutoIndex(int autoIndex) {
        this.autoIndex = autoIndex;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }
}

