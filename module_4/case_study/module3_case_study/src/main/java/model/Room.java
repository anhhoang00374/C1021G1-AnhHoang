package model;

import model.abstract_class.Service;

import java.util.List;

public class Room extends Service {
    private List<String> name_complimentary;
    private int index;
    private static int  autoIndex = 0;

    public Room() {
        this.autoIndex ++;
        this.index = autoIndex;
    }

    public Room(int id_service, String code, String serviceName, float serviceArea, float serviceCost,
                int serviceMaxPeople, String rent_type, float rent_cost, int serviceTypeId, String serviceTypeName,
                int rentTypeId, List<String> name_complimentary) {
        super(id_service, code, serviceName, serviceArea, serviceCost, serviceMaxPeople, rent_type, rent_cost,
                serviceTypeId, serviceTypeName, rentTypeId);
        this.name_complimentary = name_complimentary;
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

    public List<String> getName_complimentary() {
        return name_complimentary;
    }

    public void setName_complimentary(List<String> name_complimentary) {
        this.name_complimentary = name_complimentary;
    }
}
