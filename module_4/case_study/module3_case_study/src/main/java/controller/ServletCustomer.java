package controller;

import model.Customer;
import model.CustomerType;
import repository.impl.CustomerRepositoryImpl;
import service.IPersonService;
import service.impl.PersonServiceImpl;
import util.CodeCreating;
import util.ValidationCustomer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "ServletCustomer", value = "/ServletCustomer")
public class ServletCustomer extends HttpServlet {
    IPersonService iPersonService = new PersonServiceImpl();
    CustomerRepositoryImpl iPersonRepository = new CustomerRepositoryImpl();
    List<Customer> customerList;
    Customer customer = null;
    List<CustomerType> customerTypeList = iPersonRepository.listCustomerType();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "delete":
                showModalDelete(request,response);
            case "edit":
                showEditForm(request,response);
                break;
            default:
                showListCustomer(request,response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iPersonService.findById(id);
        customerList = iPersonService.selectAll();
        request.setAttribute("list",customerList);
        request.setAttribute("listCustomerType",customerTypeList);
        request.setAttribute("doing",1);
        request.setAttribute("customer",customer);
        try {
            request.getRequestDispatcher("customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showModalDelete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        customerList = iPersonService.selectAll();
        List<Customer> customerList1 = iPersonService.selectAll();
        Collections.sort(customerList);
        customer = customerList.get(customerList.size()-1);
        int id = customer.getId()+1;
        String customerCode = CodeCreating.setCode("KH-",id);
        request.setAttribute("list",customerList1);
        request.setAttribute("doing",1);
        request.setAttribute("id",id);
        request.setAttribute("customerCode",customerCode);
        request.setAttribute("listCustomerType",customerTypeList);

        try {
            request.getRequestDispatcher("customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        customerList = iPersonService.selectAll();
        request.setAttribute("list",customerList);
        request.setAttribute("id",0);
        //request.setAttribute("doing",0);
        try {
            request.getRequestDispatcher("customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            case "search":
                search(request,response);
                break;
            case "checkValue":
                checkValue(request,response);
            default:
                showListCustomer(request,response);
        }
    }

    private void checkValue(HttpServletRequest request, HttpServletResponse response) {
        String idPhone = request.getParameter("idPhone");
        String idCard = request.getParameter("idCare");
        System.out.println(idCard);
        System.out.println(idPhone);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = iPersonService.searchByName(name);
        if(customerList!=null){
            request.setAttribute("list",customerList);
            request.setAttribute("id",0);
        }else{
            request.setAttribute("message","Không có tên này trong danh sách");
        }
        try {
            request.getRequestDispatcher("customer.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iPersonService.delete(id);
        try {
            response.sendRedirect("/ServletCustomer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
//(int id, String code, String name, String birthday, String phone, String id_card,
// String address, String email, String customerType, boolean gender, int customer_type_id)
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("customerCode");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String idCard = request.getParameter("idCard");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int customerTypeId = Integer.parseInt(request.getParameter("customerType"));
        String customerType = null;
        for(CustomerType customerType1: customerTypeList){
            if(customerType1.getCustomer_type_id() == customerTypeId){
                customerType = customerType1.getCustomer_type_name();
            }
        }
        String gender = request.getParameter("gender");
        boolean isGender = gender.equals("man")?true:false;
        Customer customer = new Customer(id,code,name,birthday,phone,idCard,address,email,
                customerType,isGender,customerTypeId);
        Customer customer1 = iPersonService.findById(id);
        HashMap<String,String> validation = ValidationCustomer.checkMap(customer);
        if(validation.size()>0){
            customerList = iPersonService.selectAll();
            request.setAttribute("list",customerList);
            request.setAttribute("listCustomerType",customerTypeList);
            request.setAttribute("doing",1);
            request.setAttribute("customer",customer);
            try {
                request.getRequestDispatcher("customer.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            if (customer1 != null) {
                iPersonService.edit(customer);
            } else {
                iPersonService.save(customer);
            }

            try {
                response.sendRedirect("/ServletCustomer");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
