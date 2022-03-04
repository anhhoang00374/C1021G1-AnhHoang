package service;

import com.codegym.dao.IUserDAO;
import com.codegym.dao.UserDAO;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements  IUser{
    IUserDAO iUserDAO = new UserDAO();
    @Override
    public List<User> search(String country) {
        List<User> userList = iUserDAO.search(country);
        return userList;
    }

    @Override
    public User getUserById(int id) {
        return iUserDAO.getUserById(id);
    }


}
