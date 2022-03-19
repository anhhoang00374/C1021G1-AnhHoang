package service.impl;

import model.RentType;
import model.Room;
import model.ServiceType;
import model.abstract_class.Service;
import repository.IServiceRepo;
import repository.impl.ServiceRepo;

import java.util.HashMap;
import java.util.List;

public class ServiceImpl implements IService{
    IServiceRepo iServiceRepo = new ServiceRepo();
    @Override
    public HashMap<String, Service> findAll() {

        return  iServiceRepo.findAll();
    }

    @Override
    public List<ServiceType> serviceType() {
        return iServiceRepo.serviceType();
    }

    @Override
    public List<RentType> rentType() {
        return iServiceRepo.rentType();
    }

    @Override
    public void add(Room room) {
        iServiceRepo.add(room);
    }
}
