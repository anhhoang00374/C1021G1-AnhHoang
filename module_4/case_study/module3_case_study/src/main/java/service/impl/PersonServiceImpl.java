package service.impl;

import model.Customer;
import repository.IPersonRepository;
import repository.impl.CustomerRepositoryImpl;
import service.IPersonService;

import java.util.List;

public class PersonServiceImpl implements IPersonService {
    IPersonRepository iPersonRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> selectAll() {
        return iPersonRepository.selectAll();
    }

    @Override
    public void save(Customer customer) {
        iPersonRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        iPersonRepository.delete(id);
    }

    @Override
    public Customer findById(int id) {
        return iPersonRepository.findById(id);
    }

    @Override
    public void edit(Customer customer) {
        iPersonRepository.edit(customer);
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = iPersonRepository.searchByName(name);
        if(customerList.size()==0){
            return null;
        }
        return customerList;
    }
}
