package repository.repoImpl;

import model.Category;
import model.Product;
import repository.ICategoryRepo;
import until.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepoImpl implements ICategoryRepo {
    private static final String SELECT_CATEGORY = "SELECT * FROM category";

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_CATEGORY);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");

                category = new Category(id,name);
                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("abc");
        return list;
    }
}
