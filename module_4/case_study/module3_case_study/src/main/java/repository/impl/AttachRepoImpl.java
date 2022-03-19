package repository.impl;

import model.AttachService;
import model.Customer;
import repository.IAttachRepo;
import util.CodeCreating;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachRepoImpl implements IAttachRepo {
    private static final String SELECT_ATTACH_SERVICE = "SELECT * FROM attach_service";
    @Override
    public List<AttachService> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<AttachService> attachServiceList = new ArrayList<>();
        AttachService attachService = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ATTACH_SERVICE);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //int attach_service_id, String attach_service_name, String attach_service_cost,
                  //      String attach_unit, int attach_service_numbers, String service_status_status
                int attachId = resultSet.getInt("attach_service_id");
                String attachName = resultSet.getString("attach_service_name");
                int attachCost = resultSet.getInt("attach_service_cost");
                String attachUnit = resultSet.getString("attach_service_unit");
                String attachStatus = resultSet.getString("attach_service_status");
                int attachServiceNumber = resultSet.getInt("attach_service_numbers");
                attachService = new AttachService(attachId,attachName,attachCost,attachUnit,attachServiceNumber,attachStatus);
                attachServiceList.add(attachService);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attachServiceList;
    }
}
