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

public class BenhanDao implements IBenhanDao{
    private static final String SELECT_ALL_BENHAN = "SELECT * FROM benh_an;";
    private static final String UPDATE_BENHAN = "UPDATE benh_an SET ngay_nhap_vien=?,ngay_ra_vien=? WHERE id=?;";
    public BenhanDao() {
    }
    public Benhan findBenhan(String ma_benh_an){
            List<Benhan> baList = listAllBenhan();
        System.out.println(ma_benh_an+"benhnhan");
            for (Benhan benhAn : baList) {
                System.out.println(benhAn.getId()+"benhan");
                if(benhAn.getId().equals(ma_benh_an)){
                    return benhAn;
                }
            }
            return null;
    }
    @Override
    public List<Benhan> listAllBenhan() {
        List<Benhan> benhanList = new ArrayList<>();

        Connection connection = new ConnectionJDBC().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BENHAN);
            ResultSet resultSet = preparedStatement.executeQuery();
            //resultSet.beforeFirst();
            while (resultSet.next()){
                Benhan benhan = new Benhan();
                benhan.setId(resultSet.getString("id"));
                benhan.setNgayNhapVien(resultSet.getString("ngay_nhap_vien"));
                benhan.setNgayRaVien((resultSet.getString("ngay_ra_vien")));
                benhanList.add(benhan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhanList;
    }

    @Override
    public void removeBenhan(String id) {

    }

    @Override
    public void updateBenhan(Benhan benhan) {
        Connection connection = new ConnectionJDBC().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BENHAN);
            preparedStatement.setString(1,benhan.getNgayNhapVien());
            preparedStatement.setString(2, benhan.getNgayRaVien());
            preparedStatement.setString(3, benhan.getId());
            preparedStatement.executeUpdate();
            System.out.println("ERROR BENHAN");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
