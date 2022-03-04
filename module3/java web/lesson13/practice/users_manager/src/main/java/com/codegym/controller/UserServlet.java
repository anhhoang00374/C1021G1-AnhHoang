package com.codegym.controller;

import com.codegym.dao.UserDAO;
import com.codegym.model.User;
import service.IUser;
import service.UserImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private UserDAO userDAO = new UserDAO();

//        public void init() {
//            userDAO = new UserDAO();
//        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            try {
                switch (action) {
                    case "create":
                        insertUser(request, response);
                        break;
                    case "edit":
                        updateUser(request, response);
                    case "search":
                        search(request,response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

    private void search(HttpServletRequest request, HttpServletResponse response) {
            String country="";
            int id = -1;
            IUser user = new UserImpl();
            List<User> userList = new ArrayList<>();
            try{
                country = request.getParameter("country");
                id = Integer.parseInt(request.getParameter("id"));
            }catch (Exception e){
            }
            if(country!=""){
             userList.addAll(user.search(country));

            }
            User user1 = user.getUserById(id);
            userList.add(user1);
                request.setAttribute("listUser",userList);

        try {
            request.getRequestDispatcher("user/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }

            try {
                switch (action) {
                    case "create":
                        showNewForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "delete":
                        deleteUser(request, response);
                        break;
                    case "sort":
                        sort(request,response);
                        break;
                    case "permision":
                        addUserPermision(request, response);
                        break;
                    case "test-without-tran":
                        testWithoutTran(request, response);
                        break;
                    case "test-use-tran":
                        testUseTran(request, response);
                        break;

                    default:
                        listUser(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = userDAO.sort();

        request.setAttribute("listUser", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }


    private void listUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            List<User> listUser = userDAO.selectAllUsers();
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
            dispatcher.forward(request, response);
        }

        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
            dispatcher.forward(request, response);
        }

        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            User existingUser = userDAO.selectUser(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
            request.setAttribute("user", existingUser);
            dispatcher.forward(request, response);

        }

        private void insertUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");
            User newUser = new User(name, email, country);
            userDAO.insertUser(newUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
            dispatcher.forward(request, response);
        }

        private void updateUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");

            User book = new User(id, name, email, country);
            userDAO.updateUser(book);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
            dispatcher.forward(request, response);
        }

        private void deleteUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            int id = Integer.parseInt(request.getParameter("id"));
            userDAO.deleteUser(id);

            List<User> listUser = userDAO.selectAllUsers();
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
            dispatcher.forward(request, response);
        }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {

        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");

        int[] permision = {1, 2, 4};

        userDAO.addUSerTransaction(user, permision);

    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {

        userDAO.insertUpdateWithoutTransaction();

    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {

      userDAO.insertUpdateUseTransaction();

    }
}
