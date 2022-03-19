package controller;

import model.Account;
import service.AccountServiceImpl;
import service.IAccount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletHome", value = "")
public class ServletHome extends HttpServlet {
    IAccount iAccount = new AccountServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        if(status==null){
            status="";
        }
        switch (status){
            case "signIn": {
                request.getRequestDispatcher("homeSignIn.jsp").forward(request,response);
            }
                break;
            case "signUp":{
                signUp(request,response);
            }
                break;
            default:
                Cookie[] cookies = request.getCookies();
                if(cookies!=null) {
                    for (Cookie cookie : cookies) {
                        System.out.println(cookie.getName());
                        if (cookie.getName().equals("name")) {

                            request.setAttribute("name", cookie.getValue());
                            System.out.println(cookie.getValue());
                        }
                        if (cookie.getName().equals("ps")) {
                            System.out.println(cookie.getValue());
                            request.setAttribute("ps", cookie.getValue());
                        }
                    }
                }
                    request.getRequestDispatcher("home.jsp").forward(request,response);
                    break;


        }

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        if(status==null){
            status="";
        }
        switch (status){
            case "signIn": {
                signIn(request,response);
            }
            break;
            case "signUp":{
                signUp(request,response);
            }
            break;
            default:
                request.getRequestDispatcher("home.jsp").forward(request,response);
        }

    }

    private void signIn(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String userPs = request.getParameter("userPassword");
        Account account = new Account(userName,userPs);
        iAccount.addAccount(account);
        try {
            response.sendRedirect("/");
           // request.getRequestDispatcher("home.jsp").forward(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String userPs = request.getParameter("userPassword");
        String check = request.getParameter("remember");
        System.out.println(check);
        Account account = new Account(userName,userPs);
        boolean checkSignIn = iAccount.checkAccount(account);

        System.out.println(checkSignIn);
        if(checkSignIn){
            try {
                if(check==null){
                    check="";
                }
                if(check.equals("on")){
                    Cookie nameCookie = new Cookie("name",userName);
                    Cookie psCookie = new Cookie("ps",userPs);
                    response.addCookie(nameCookie);
                    response.addCookie(psCookie);
                }else{
                    Cookie[] cookies = request.getCookies();
                    if(cookies!=null)
                        for (int i = 0; i < cookies.length; i++) {
                            if(cookies[i].getName().equals("name")){
                                cookies[i].setMaxAge(0);
                                response.addCookie(cookies[i]);
                            }
                            if(cookies[i].getName().equals("ps")){
                                cookies[i].setMaxAge(0);
                                response.addCookie(cookies[i]);
                            }
                        }
                }
                request.getSession().setAttribute("userName",userName);
                request.getRequestDispatcher("homeSignUp.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                response.sendRedirect("home.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
