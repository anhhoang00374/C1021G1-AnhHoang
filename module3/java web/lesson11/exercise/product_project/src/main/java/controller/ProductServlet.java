package controller;

import model.Product;
import org.omg.PortableServer.POA;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "")
public class ProductServlet extends HttpServlet {
    List<Product> productList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            case "seeDetail":
                seeDetail(request,response);
                break;
            default:
                displayList(request,response);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "search":
                search(request,response);
                break;
            default:
                displayList(request,response);
        }
    }

    private void displayList(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("productList",productList);
        try {
            request.getRequestDispatcher("home.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request,HttpServletResponse response){
        try {
            request.getRequestDispatcher("create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            for(Product product: productList){
                if(product.getId()==id){
                    request.setAttribute("product",product);
                }
            }
            request.getRequestDispatcher("edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String producer = request.getParameter("producer");
        Product product = new Product(name,price,producer);
        productList.add(product);
        try {
//            request.setAttribute("productList",productList);
//            request.getRequestDispatcher("home.jsp").forward(request,response);
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String producer = request.getParameter("producer");
        for(Product product :productList){
            if(product.getId()==id){
                product.setName(name);
                product.setProducer(producer);
                product.setPrice(price);
            }
        }

        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showDelete(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        for(Product product : productList){
            if(product.getId() == id){
                request.setAttribute("product",product);
            }
        }

        try {
            request.getRequestDispatcher("delete.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  void delete(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        for(Product product : productList){
            if(product.getId()==id){
                productList.remove(product);
            }
        }
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seeDetail(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        for(Product product:productList){
            if(product.getId()==id){
                request.setAttribute("product",product);
            }
        }

        try {
            request.getRequestDispatcher("detail.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("search");
        List<Product> products = new ArrayList<>();
        for(Product product:productList){
            if(product.getName().equals(name)){
                products.add(product);
            }
        }
        request.setAttribute("listProduct",products);
        request.setAttribute("name",name);
        request.setAttribute("size",products.size());
        try {
            request.getRequestDispatcher("searching.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
