package repository;

import model.Customer;

import java.util.List;

public interface IPersonRepository {

    List<Customer> selectAll();
    void save(Customer customer);

    void delete(int id);

    Customer findById(int id);

    void edit(Customer customer);

    List<Customer> searchByName(String name);
}
