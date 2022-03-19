package controller;

import model.*;
import model.abstract_class.Contract;
import model.abstract_class.Service;
import service.IAttachService;
import service.IContractService;
import service.IPersonService;
import service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletContract", value = "/ServletContract")
public class ServletContract extends HttpServlet {
    IContractService iContractService = new ContractServiceImpl();
    IPersonService iPersonService = new PersonServiceImpl();
    IEmployeeService iEmployeeService = new EmployeeImpl();
    IService iService = new ServiceImpl();
    IAttachService iAttachService = new AttachServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            default:
                displayContract(request,response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("doing",1);
        List<Contract> contractList = iContractService.selectAll();
        Contract contract = contractList.get(contractList.size()-1);
        request.setAttribute("listContract",contractList);
        List<AttachService> attachServiceList = iAttachService.findAll();
        request.setAttribute("listAttach",attachServiceList);
        int id = contract.getContractId();
        request.setAttribute("id",id+1);
        List<Customer> customerList = iPersonService.selectAll();
        List<Employee> employeeList = iEmployeeService.selectAll();
        HashMap<String, Service> serviceHashmap = iService.findAll();
        List<Service> serviceList = new ArrayList<>();
            for(Map.Entry<String, Service> entry : serviceHashmap.entrySet()) {
                String key = entry.getKey();
                Service service = entry.getValue();
                if(key.contains("house")){
                    serviceList.add((House) service);
                }else if(key.contains("villa")){
                    serviceList.add((Villa) service);
                }
            }

        request.setAttribute("listService",serviceList);
        request.setAttribute("listCustomer",customerList);
        request.setAttribute("listEmployee",employeeList);
        try {
            request.getRequestDispatcher("contract.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = iContractService.selectAll();
        request.setAttribute("listContract",contractList);
        try {
            request.getRequestDispatcher("contract.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "create":
                createContract(request,response);
                break;
            default:
                displayContract(request,response);
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
    }
}
