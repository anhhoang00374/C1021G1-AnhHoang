package service.impl;

import model.RentType;
import model.Room;
import model.ServiceType;
import model.abstract_class.Service;

import java.util.HashMap;
import java.util.List;

public interface IService {
    HashMap<String, Service> findAll();

    List<ServiceType> serviceType();

    List<RentType> rentType();

    void add(Room room);
}
