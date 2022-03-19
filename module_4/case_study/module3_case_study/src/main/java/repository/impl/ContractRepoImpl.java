package repository.impl;

import model.Account;
import model.abstract_class.Contract;
import repository.IContractRepo;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepoImpl implements IContractRepo {
    private static final String SELECT_ALL_CONTRACT = "SELECT * FROM contract join customer" +
            " on contract.customer_id = customer.customer_id " +
            "join employee on contract.employee_id = employee.employee_id " +
            "join service on service.service_id = contract.service_id";
    @Override
    public List<Contract> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Contract> contractList = new ArrayList<>();
        Contract contract = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //int contractId, String contractStartDate, String contractEndDate, float contractDeposit, float contractTotalMoney,
                //                    String employeeName, String customerName, String serviceName,
                //                    int employeeId, int customerId, int serviceId, List<ContractDetail> listAttachService)

                int contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                float contractDeposit = resultSet.getInt("contract_deposit");
                float contractTotalMoney = resultSet.getInt("contract_total_money");
                String employeeName = resultSet.getString("employee_name");
                String customerName = resultSet.getString("customer_name");
                String serviceName = resultSet.getString("service_name");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int serviceId = resultSet.getInt("service_id");
                contract = new Contract(contractId,contractStartDate,contractEndDate,contractDeposit,contractTotalMoney,employeeName,
                        customerName,serviceName,employeeId,customerId,serviceId,null);
                contractList.add(contract);
                System.out.println(contractList.size());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  contractList;
    }
}
