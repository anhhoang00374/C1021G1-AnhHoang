package controller;

import dao.CustomerDao;
import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "controller.ServletDemo", value = "/")
public class ServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action){
            case "/save":
                addNewCustomer(request, response);
                break;
            case "/create":
                showNewCustomer(request, response);
                break;
            case "/delete":
                deleteCustomer(request,response);
                break;
            case "/edit":
                editCustomer(request, response);
                break;
            case "/update":
                updateCustomer(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = CustomerDao.getAllCustomer();
        request.setAttribute("listCustomer",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request,response);
    }
    private void deleteCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerDao.deleteCustomer(id);
        response.sendRedirect("/");
    }
    private void showNewCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("createNewCustomer.jsp").forward(request,response);
    }
    private void addNewCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer checkCustomer = CustomerDao.getCustomer(id);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        if(checkCustomer == null){
            CustomerDao.addCustomer(new Customer(id,name,phone,email));
            response.sendRedirect("/");
        }else{
            request.setAttribute("messeger","id is exited");
            request.setAttribute("name",name);
            request.setAttribute("email",email);
            request.setAttribute("phone",phone);
            request.getRequestDispatcher("createNewCustomer.jsp").forward(request,response);
        }

    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = CustomerDao.getCustomer(id);
        request.setAttribute("customer",customer);
       request.getRequestDispatcher("editCustomer.jsp").forward(request,response);
    }
    private void updateCustomer(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer checkCustomer = CustomerDao.getCustomer(id);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        CustomerDao.addCustomer(new Customer(id,name,phone,email));
        response.sendRedirect("/");
    }
}
