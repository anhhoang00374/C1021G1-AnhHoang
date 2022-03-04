package repository.repoImpl;

import model.Product;
import model.Student;
import repository.IRepository;
import until.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IRepository {
    private static final String SELECT_ALL = "SELECT * FROM product join category on product.category_id = category.category_id;";
    private static final String INSERT = "INSERT INTO product(name,price,quantity,color,description_product,category_id) value(?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM product where product_id = ?";
    private static final String UPDATE = "UPDATE product set name = ?,price = ?,quantity=?,color = ?,category_id=? where product_id=?";
    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity= resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description_product");
                int categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                product = new Product(id,name,price,quantity,description,color,categoryId,categoryName);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("abc");
        return list;
    }

    @Override
    public void save(Product product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //customer_name,customer_birthday,customer_gender,customer_id_card," +
        //            "customer_phone,customer_email,customer_address,customer_type_id
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategory_id());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(123);
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareCall(DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(Product product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // "UPDATE customer SET customer_name = ?,customer_birthday = ?,customer_gender = ?,customer_id_card = ?," +
        //            "customer_phone = ?,customer_email = ? ,customer_address = ?,customer_type_id = ? WHERE customer_id = ?";
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setInt(5,product.getCategory_id());
            preparedStatement.setInt(6,product.getId_product());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
