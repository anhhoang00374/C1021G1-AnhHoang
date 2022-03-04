package controller;

import model.Employee;
import service.impl.EmployeeImpl;
import service.impl.IEmployeeService;
import util.CodeCreating;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "ServletEmployee", value = "/ServletEmployee")
public class ServletEmployee extends HttpServlet {
    IEmployeeService employeeService = new EmployeeImpl();
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
                //showModalDelete(request,response);
            case "edit":
                //showEditForm(request,response);
                break;
            default:
                showListCustomer(request,response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("doing",1);
        List<Employee> employeeList = employeeService.selectAll();
        request.setAttribute("id",employeeList.size()+1);
        request.setAttribute(("code"), CodeCreating.setCode("NV-",employeeList.size()+1));
        request.setAttribute("list",employeeList);
        try {
            request.getRequestDispatcher("employee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.selectAll();
        request.setAttribute("list",employeeList);
        try {
            request.getRequestDispatcher("employee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
