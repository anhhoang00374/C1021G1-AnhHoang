package service.impl;

import model.Customer;
import model.Employee;
import repository.IEmployeeRepo;
import repository.impl.EmployeeRepo;
import service.IPersonService;

import java.util.List;

public class EmployeeImpl implements IEmployeeService {
    IEmployeeRepo iEmployeeRepo = new EmployeeRepo();
    @Override
    public List<Employee> selectAll() {
        return iEmployeeRepo.selectAll();
    }
}
