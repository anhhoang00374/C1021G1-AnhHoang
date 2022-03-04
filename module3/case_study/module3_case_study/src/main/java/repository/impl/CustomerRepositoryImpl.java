package repository.impl;

import model.Customer;
import model.CustomerType;
import repository.IPersonRepository;
import util.CodeCreating;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerRepositoryImpl implements IPersonRepository {
    List<Customer> customerList = null;
    List<CustomerType> customerTypeList = null;

    private static final String SELECT_CONTRACTS_BY_CUSTOMER_ID = "SELECT * FROM contract WHERE customer_id = ?;";
    private static final String SELECT_CONTRACT_DETAILS_BY_CONTRACT_ID = "SELECT * FROM contract_detail WHERE contract_id = ?;";
    private static final String DELETE_CUSTOMER_BY_ID = "DELETE FROM customer WHERE id = ?;";
    private static final String SELECT_ALL_CUSTUMERS_TYPE = "SELECT * FROM customer_type;";
    private  static final String SELECT_CUSTOMER_BY_NAME = "SELECT * FROM customer inner join customer_type on customer_type.customer_type_id=customer.customer_type_id WHERE customer_name LIKE ?;";
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customer inner join customer_type on customer_type.customer_type_id=customer.customer_type_id";
    private static final String CREATE_CUSTOMER = "INSERT INTO customer(customer_id,customer_name,customer_birthday,customer_gender,customer_id_card," +
            "customer_phone,customer_email,customer_address,customer_type_id)values (?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer inner join customer_type on customer_type.customer_type_id=customer.customer_type_id WHERE customer_id = ?;";
    private static final String UPDATE_CUSTOMER = "UPDATE customer SET customer_name = ?,customer_birthday = ?,customer_gender = ?,customer_id_card = ?," +
            "customer_phone = ?,customer_email = ? ,customer_address = ?,customer_type_id = ? WHERE customer_id = ?";

    @Override
    public List<Customer> selectAll() {
        Customer.setAutoId();
        customerList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                int id = resultSet.getInt("customer_id");
                String code = CodeCreating.setCode("KH-",id);
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                boolean gender = resultSet.getBoolean("customer_gender");
                String  idCard= resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                String email = resultSet.getString("customer_email");
                String customerType = resultSet.getString("customer_type_name");
                int customerTypeId = resultSet.getInt("customer_type_id");
                //(int id, String code, String name, String birthday, String phone, String id_card,
                //                    String address, String email, String customer_type, String gender, int customer_type_id)
                customer = new Customer(id,code,name,birthday,phone,idCard,address,email,customerType,gender,customerTypeId);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //customer_name,customer_birthday,customer_gender,customer_id_card," +
        //            "customer_phone,customer_email,customer_address,customer_type_id
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_CUSTOMER);
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getBirthday());
            preparedStatement.setBoolean(4, customer.isGender());
            preparedStatement.setString(5,customer.getId_card());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.setInt(9,customer.getCustomerTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Integer> listContractId = contractList(id);
        System.out.println(listContractId);
        List<Integer> listContractDetailId = new ArrayList<>();
        for(int idContract:listContractId){
            listContractDetailId.addAll(contractDetailList(idContract));
        }
        System.out.println(listContractDetailId);

        for(int detailId: listContractDetailId){
            delete_contract_detail(detailId);
        }

        for(int contractId:listContractId){
            delete_contract(contractId);
        }

        try{
            connection = DBConnection.getConnection();
            callableStatement = connection.prepareCall("{call delete_customer(?)}");
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Customer findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                //int idC = resultSet.getInt("customer_id");
                String code = CodeCreating.setCode("KH-",id);
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                boolean gender = resultSet.getBoolean("customer_gender");
                String  idCard= resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                String email = resultSet.getString("customer_email");
                String customerType = resultSet.getString("customer_type_name");
                int customerTypeId = resultSet.getInt("customer_type_id");
                //(int id, String code, String name, String birthday, String phone, String id_card,
                //                    String address, String email, String customer_type, String gender, int customer_type_id)
                customer = new Customer(id,code,name,birthday,phone,idCard,address,email,customerType,gender,customerTypeId);
                //customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public void edit(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // "UPDATE customer SET customer_name = ?,customer_birthday = ?,customer_gender = ?,customer_id_card = ?," +
        //            "customer_phone = ?,customer_email = ? ,customer_address = ?,customer_type_id = ? WHERE customer_id = ?";
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getBirthday());
            preparedStatement.setBoolean(3, customer.isGender());
            preparedStatement.setString(4,customer.getId_card());
            preparedStatement.setString(5,customer.getPhone());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setString(7,customer.getAddress());
            preparedStatement.setInt(8,customer.getCustomerTypeId());
            preparedStatement.setInt(9,customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Customer> searchByName(String name) {
        Customer.setAutoId();
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1,"%"+name+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                int id = resultSet.getInt("customer_id");
                String code = CodeCreating.setCode("KH-",id);
                String nameC = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                boolean gender = resultSet.getBoolean("customer_gender");
                String  idCard= resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                String email = resultSet.getString("customer_email");
                String customerType = resultSet.getString("customer_type_name");
                int customerTypeId = resultSet.getInt("customer_type_id");
                //(int id, String code, String name, String birthday, String phone, String id_card,
                //                    String address, String email, String customer_type, String gender, int customer_type_id)
                customer = new Customer(id,code,nameC,birthday,phone,idCard,address,email,customerType,gender,customerTypeId);

                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }


    public List<CustomerType> listCustomerType(){
         customerTypeList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTUMERS_TYPE);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                int id = resultSet.getInt("customer_type_id");
                String customerType = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id,customerType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }

    private List<Integer> contractList(int id){
        List<Integer> contractIdList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_CONTRACTS_BY_CUSTOMER_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int contractId = resultSet.getInt("contract_id");
                contractIdList.add(contractId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  contractIdList;

    }

    private void delete_contract(int id){
        Connection connection = null;
        CallableStatement callableStatement = null;
        try{
            connection = DBConnection.getConnection();
            callableStatement = connection.prepareCall("{call delete_contract(?)}");
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void delete_contract_detail(int id){
        Connection connection = null;
        CallableStatement callableStatement = null;
        try{
            connection = DBConnection.getConnection();
            callableStatement = connection.prepareCall("{call delete_contract_detail(?)}");
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private List<Integer> contractDetailList(int id){
        List<Integer> contractDetailIdList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAILS_BY_CONTRACT_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                int contractId = resultSet.getInt("contract_detail_id");
                System.out.println(contractId);
                contractDetailIdList.add(contractId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  contractDetailIdList;

    }


}
