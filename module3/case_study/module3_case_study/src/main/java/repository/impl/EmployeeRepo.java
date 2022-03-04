package repository.impl;

import model.Customer;
import model.Employee;
import repository.IEmployeeRepo;
import util.CodeCreating;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo {
    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee join position on employee.position_id = position.position_id \n" +
            "join division on division.division_id = employee.division_id\n" +
            "join education_degree on education_degree.education_degree_id=employee.education_degree_id;";
    @Override
    public List<Employee> selectAll() {

        Employee.reStartAutoIndex();
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //int id, String code, String name, String birthday,
                //                    String phone, String id_card, String address, String email, float salary,
                //                    String position, String division, String educationDegree,
                //                    String userName, int position_id, int education_id, int division_id)
                int id = resultSet.getInt("employee_id");
                String code = CodeCreating.setCode("NV-",id);
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String phone = resultSet.getString("employee_phone");
                String  idCard= resultSet.getString("employee_id_card");
                String address = resultSet.getString("employee_address");
                String email = resultSet.getString("employee_email");
                float salary = resultSet.getInt("employee_salary");
                String position = resultSet.getString("position_name");
                String division = resultSet.getString("division_name");
                String education = resultSet.getString("education_degree_name");
                String userName = "";
                int positionId = resultSet.getInt("position_id");
                int educationId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("position_id");
                //(int id, String code, String name, String birthday, String phone, String id_card,
                //                    String address, String email, String customer_type, String gender, int customer_type_id)
                employee = new Employee(id,code,name,birthday,phone,idCard,address,email,salary,position,division,education,
                        userName,positionId,educationId,divisionId);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }
}
