package com.secshow.demo.service;

import com.secshow.demo.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    int userLogin(User user);

    List<User> getAllUsers();
}
