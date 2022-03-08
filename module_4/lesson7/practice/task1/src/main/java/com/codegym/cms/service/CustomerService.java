package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        if(iCustomerRepository.findById(id).get()!=null){
            iCustomerRepository.delete(iCustomerRepository.findById(id).get());
        }

    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return iCustomerRepository.findAllByProvince(province);
    }
}
