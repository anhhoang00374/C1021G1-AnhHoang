package repository.impl;

import model.Account;
import model.Customer;
import repository.IAccountRepo;
import util.CodeCreating;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepoImpl implements IAccountRepo {
    List<Account> accountList = null;
    private static final String SELECT_ALL_ACCOUNT = "SELECT * FROM user_account";
    private static final String INSERT_ACCOUNT = "INSERT INTO user_account(user_name,user_password)values(?,?);";
    @Override
    public boolean checkAccount(Account user) {
        List<Account> accounts = findAll();
        for(Account account: accounts){
            if(account.getUserName().equals(user.getUserName())&&
                    account.getUserPassword().equals(user.getUserPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Account> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        accountList = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String userName = resultSet.getString("user_name");
                String userPassword = resultSet.getString("user_password");
                //(int id, String code, String name, String birthday, String phone, String id_card,
                //                    String address, String email, String customer_type, String gender, int customer_type_id)
                Account account = new Account(userName,userPassword);
                accountList.add(account);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accountList;
    }

    @Override
    public void addAccount(Account account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1,account.getUserName());
            preparedStatement.setString(2,account.getUserPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
