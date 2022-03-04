package controller;

import model.Category;
import model.Product;
import model.Student;
import service.ICategoryService;
import service.IProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletModule3", value = "/")
public class ServletModule3 extends HttpServlet {
    IProductService iproductService = new ProductService();
    ICategoryService iCategoryService = new CategoryServiceImpl();
    List<Category> categoryList = iCategoryService.findAll();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "add":
                break;
            case "edit":
                showEditForm(request,response);
                break;
            default:
                displayList(request,response);
                break;
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> list = iproductService.findAll();
        Product product = null;
        for(Product product1:list){
            if(product1.getId_product() == id){
                product = product1;
            }
        }
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("product",product);
        try {
            request.getRequestDispatcher("create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("categoryList",categoryList);
        try {
            request.getRequestDispatcher("create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = iproductService.findAll();
        request.setAttribute("list",list);
        System.out.println(list.size());
        try {
            request.getRequestDispatcher("home.jsp").forward(request,response);
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
                addNew(request,response);
                break;
            case "add":
                addNew(request,response);
                break;
            case "edit":
                //add(request,response);
                update(request,response);
                break;
            case "delete":
                delete(request,response);
            default:
                displayList(request,response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id+"sasa");
        String name = request.getParameter("name");
        int price = Integer.parseInt((request.getParameter("price")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = (request.getParameter("description"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(id,name,price,quantity,description,color,categoryId,description);
        iproductService.update(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
       int id = Integer.parseInt(request.getParameter("id"));
       iproductService.delete(id);
        List<Product> list = iproductService.findAll();
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("home.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void add(HttpServletRequest request, HttpServletResponse response) {
//        Student student = new Student(1,"f");
//        iproductService.save(student);
//    }

    private void addNew(HttpServletRequest request, HttpServletResponse response) {
        String date = request.getParameter("birthday");
        String name = request.getParameter("name");
        int price = Integer.parseInt((request.getParameter("price")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = (request.getParameter("description"));
        int categoryId = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name,price,quantity,date,color,categoryId,description);
        iproductService.save(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
