package repository.impl;

import model.*;
import model.abstract_class.Service;
import repository.IServiceRepo;
import util.CodeCreating;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceRepo implements IServiceRepo {
//    private static final String SELECT_ALL_SERVICE = "SELECT * FROM service_type join service " +
//            "on service_type.service_type_id=service.service_type_id" +
//            "join rent_type on rent_type.rent_type_id=service.rent_type_id";
        private static final String SELECT_SERVICE_TYPE = "SELECT * FROM service_type";
        private static final String INSERT_INTO_SERVICE = "INSERT INTO service(service_name,service_area,service_cost,service_max_people,standard_room,description_other_convenience,\n" +
                "pool_area,number_of_floors,rent_type_id,service_type_id) value (?,?,?,?,?,?,?,?,?,?);";
        private static final String SELECT_SERVICE_RENT_TYPE = "SELECT * FROM rent_type";
        private static final String SELECT_ALL_SERVICE = "SELECT * FROM service_type join service on service_type.service_type_id=service.service_type_id join rent_type on rent_type.rent_type_id=service.rent_type_id;";
        @Override
    public HashMap<String, Service> findAll() {
        Room.restartIndexAuto();
        House.restartIndexAuto();
        Villa.restartIndexAuto();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        FuramaService furamaService = null;
        List<FuramaService> furamaServiceList = null;
        HashMap<String,Service> stringServiceHashMap = null;
        try {
            furamaServiceList = new ArrayList<>();
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idService = resultSet.getInt("service_id");
                String code = CodeCreating.setCode("DV-",idService);
                String serviceName = resultSet.getString("service_name");
                float serviceArea = resultSet.getInt("service_area");
                float serviceCost = resultSet.getInt("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                String rentType = resultSet.getString("rent_type_name");
                float rentCost = resultSet.getInt("rent_type_cost");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                int rentTypeId = resultSet.getInt("rent_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                float poolArea = resultSet.getInt("pool_area");
                int numberOfFloor = resultSet.getInt("number_of_floors");
                List<String> nameComplimentary = new ArrayList<>();
                furamaService = new FuramaService(idService,code,serviceName,serviceArea,serviceCost,serviceMaxPeople,rentType,rentCost,
                        serviceTypeId,serviceTypeName,rentTypeId,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloor,nameComplimentary);
                furamaServiceList.add(furamaService);
            }
            stringServiceHashMap = checkService(furamaServiceList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stringServiceHashMap;
    }

    @Override
    public List<ServiceType> serviceType() {
        List<ServiceType> serviceTypes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ServiceType serviceType = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_SERVICE_TYPE);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");
                serviceType = new ServiceType(id,name);
                serviceTypes.add(serviceType);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypes;
    }

    @Override
    public List<RentType> rentType() {
        List<RentType> rentTypes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        RentType rentType = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_SERVICE_RENT_TYPE);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                float cost = resultSet.getFloat("rent_type_cost");
                rentType = new RentType(id,name,cost);
                rentTypes.add(rentType);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypes;
    }

    @Override
    public void add(Room room) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INTO_SERVICE);
            //INSERT INTO service(service_name,service_area,service_cost,service_max_people,standard_room,
            // description_other_convenience,\n" +
            //        "pool_area,number_of_floors,rent_type_id,service_type_id)
            preparedStatement.setString(1,room.getServiceName());
            preparedStatement.setInt(2, (int) room.getServiceArea());
            preparedStatement.setInt(3, (int) room.getServiceCost());
            preparedStatement.setInt(4,room.getServiceMaxPeople());
            preparedStatement.setString(5,"");
            preparedStatement.setString(6,"");
            preparedStatement.setInt(7,0);
            preparedStatement.setInt(8,0);
            preparedStatement.setInt(9,room.getRentTypeId());
            preparedStatement.setInt(10,room.getServiceTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String,Service> checkService(List<FuramaService> serviceList){
        HashMap<String,Service> stringServiceHashMap = new HashMap<>();
        for(FuramaService service:serviceList){
            if(service.getServiceTypeName().toLowerCase().equals("room")){
                Room room = new Room(service.getId_service(),service.getCode(),service.getServiceName(),service.getServiceArea(),
                        service.getServiceCost(),service.getServiceMaxPeople(),service.getRent_type(),service.getRent_cost(),
                        service.getServiceTypeId(),service.getServiceTypeName(),service.getRentTypeId(),null);
                stringServiceHashMap.put("room"+service.getId_service(),room);
            }else if(service.getServiceTypeName().toLowerCase().equals("house")){
                House house = new House(service.getId_service(),service.getCode(),service.getServiceName(),service.getServiceArea(),
                        service.getServiceCost(),service.getServiceMaxPeople(),service.getRent_type(),service.getRent_cost(),
                        service.getServiceTypeId(),service.getServiceTypeName(),service.getRentTypeId(),service.getStandard_room(),service.getDescription_other_convenience(),
                        service.getNumber_of_floors());
                stringServiceHashMap.put("house"+service.getId_service(),house);
            }else {
                Villa villa = new Villa(service.getId_service(),service.getCode(),service.getServiceName(),
                        service.getServiceArea(),service.getServiceCost(),service.getServiceMaxPeople(),service.getRent_type(),
                        service.getRent_cost(),service.getServiceTypeId(),service.getServiceTypeName(),service.getRentTypeId(),
                        service.getStandard_room(),service.getDescription_other_convenience(),service.getPool_area(),service.getNumber_of_floors());
                stringServiceHashMap.put("villa"+service.getId_service(),villa);
            }
        }
        return stringServiceHashMap;
    }

}
