package model;

import model.abstract_class.Service;

import java.util.List;

public class FuramaService extends Service {
    private String standard_room;
    private String description_other_convenience;
    private float pool_area;
    private int number_of_floors;
    private List<String> name_complimentary;
    private int index;
    private int autoIndex = 0;

    public FuramaService() {
        this.autoIndex ++;
        this.index = autoIndex;
    }

    public FuramaService(int id_service, String code, String serviceName, float serviceArea, float serviceCost,
                         int serviceMaxPeople, String rent_type, float rent_cost, int serviceTypeId,
                         String serviceTypeName, int rentTypeId, String standard_room,
                         String description_other_convenience,
                         float pool_area, int number_of_floors, List<String> name_complimentary) {
        super(id_service, code, serviceName, serviceArea, serviceCost, serviceMaxPeople, rent_type, rent_cost, serviceTypeId, serviceTypeName, rentTypeId);
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
        this.name_complimentary = name_complimentary;
        this.autoIndex ++;
        this.index = autoIndex;
    }

    public void restartIndexAuto(){
        this.autoIndex = 0;
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

    public float getPool_area() {
        return pool_area;
    }

    public void setPool_area(float pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public List<String> getName_complimentary() {
        return name_complimentary;
    }

    public void setName_complimentary(List<String> name_complimentary) {
        this.name_complimentary = name_complimentary;
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

    @Override
    public String toString() {
        return "FuramaService{" +
                "standard_room='" + standard_room + '\'' +
                ", description_other_convenience='" + description_other_convenience + '\'' +
                ", pool_area=" + pool_area +
                ", number_of_floors=" + number_of_floors +
                ", name_complimentary=" + name_complimentary +
                ", index=" + index +
                ", autoIndex=" + autoIndex +
                '}';
    }
}
