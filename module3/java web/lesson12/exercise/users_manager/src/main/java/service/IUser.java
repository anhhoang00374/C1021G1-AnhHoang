package service;

import com.codegym.model.User;

import java.util.List;

public interface IUser {
    List<User> search (String country);
}
