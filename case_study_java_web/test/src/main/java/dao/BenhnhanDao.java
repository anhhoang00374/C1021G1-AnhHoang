package dao;

import model.Benhan;
import model.Benhnhan;
import utilities.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhnhanDao implements IBenhnhanDao{
    private static final String SELECT_ALL_BENHAN = "SELECT * FROM benh_nhan;";
    private static final String UPDATE_BENHNHAN = "UPDATE benh_nhan SET ten_benh_nhan=?,ly_do_nhap_vien=? WHERE id=?;";
    public BenhnhanDao() {

    }

    @Override
    public List<Benhnhan> listAllBenhnhan() {
        List<Benhnhan> benhnhanList = new ArrayList<>();

        Connection connection = new ConnectionJDBC().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BENHAN);
            ResultSet resultSet = preparedStatement.executeQuery();
            //resultSet.beforeFirst();
            while (resultSet.next()){
                Benhnhan benhnhan = new Benhnhan();
                benhnhan.setId(resultSet.getString("id"));
                benhnhan.setTenBenhnhan(resultSet.getString("ten_benh_nhan"));
                benhnhan.setLido(resultSet.getString("ly_do_nhap_vien"));
                benhnhan.setMaBenhnhan(resultSet.getString("ma_benh_an"));
                benhnhanList.add(benhnhan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhnhanList;
    }

    @Override
    public void removeBenhnhan(String id) {

    }

    @Override
    public void updateBenhnhan(Benhnhan benhnhan) {
        Connection connection = new ConnectionJDBC().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENHNHAN);
            preparedStatement.setString(1,benhnhan.getTenBenhnhan());
            preparedStatement.setString(2, benhnhan.getLido());
            preparedStatement.setString(3, benhnhan.getId());
            preparedStatement.executeUpdate();
            System.out.println("ERROR BENHNHAN");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
