package com.secshow.demo.service;

import com.secshow.demo.model.User;
import com.secshow.demo.model.VO.UserQueryVO;
import com.secshow.demo.model.VO.UserVO;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    UserVO userLogin(User user);

    UserVO userRegister(User user);

    List<User> getAllUsers();

    Integer updateUser(User user);

    Integer delUser(Integer userId);

    Integer activeUser(Integer userId);

    List<User> queryVOUser(UserQueryVO userQueryVO);
}
