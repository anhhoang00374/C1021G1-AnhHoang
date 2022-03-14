package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.repository.CustomerRepository;
import cg.wbd.grandemonstration.repository.ICustomerRepository;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.SystemException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class SimpleCustomerServiceImpl implements CustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
       return  customerRepository.findAll();
    }

    @Override
    public Customer findOne(Long id) {
      return customerRepository.findOne(id);
    }

    @Override
    public Customer save(Customer customer) throws SystemException {
       return  customerRepository.save(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
       return customerRepository.save(customers);
    }

    @Override
    public boolean exists(Long id) {
      return customerRepository.exists(id);
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
       return  customerRepository.findAll(ids);
    }

    @Override
    public long count() {
       return customerRepository.count();
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void delete(Customer customer) {
       customerRepository.delete(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        customers.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
    }

}
