package com.codegym.dao;

import com.codegym.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    private String JDBCURL = "jdbc:mysql://localhost:3306/jdbc_practice";
    private String JDBCUSERNAME = "root";
    private String JDBCPASSWORD = "ahhoang00374";
    private String sortValue = "ASC";
    private static final String INSERT_USERS_SQL = "INSERT INTO users(name,email,country) VALUES (?,?,?);";
    private static final String SELECT_USER_BY_ID = "SELECT id,name,email,country from users where id = ?;";
//    private static final String SELECT_ALL_USERS = "SELECT * FROM users order by name;";
//    private static final String DELETE_USERS_SQL = "DELETE FROM USERS WHERE id = ?;";
//    private static final String UPDATE_USERS_SQL = "UPDATE USERS SET name = ?,email = ?,country = ? where id = ?;";
    private  static final String SELECT_ALL_BY_COUNTRY = "SELECT * FROM USERS WHERE country like ? ";
    private static final String SELECT_ALL_USERS = "CALL display_all_list()";
    private static final String UPDATE_USER = "{CALL update_user(?,?,?,?)}";
    private static final String DELETE_USER = "{CALL delete_user(?)}";
    public UserDAO(){
    }

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBCURL,JDBCUSERNAME,JDBCPASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.getErrorCode();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
            }
        } catch (SQLException e) {
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//            System.out.println(preparedStatement);
            //preparedStatement.setString(1,sortValue);
             CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_USERS);
             ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
        }
    } catch (SQLException e) {
        }
        System.out.println(users.size());
        return users;
    }

    public List<User>  sort(){

        sortValue = sortValue.equals("ASC")?"DESC":"ASC";
        System.out.println(sortValue);
        List<User> users = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs =  statement.executeQuery("SELECT * FROM users order by name "+ sortValue);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            //PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            CallableStatement callableStatement = connection.prepareCall(DELETE_USER);
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        }catch (Exception e){

        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            //PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)
            CallableStatement statement = connection.prepareCall(UPDATE_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }catch (Exception e){

        }
        return rowUpdated;
    }

    public List<User> search(String inputCountry){
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BY_COUNTRY);) {
            statement.setString(1, "%"+inputCountry+"%");
            User user;
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
}
