package com.secshow.demo.controller;

import com.secshow.demo.model.User;
import com.secshow.demo.model.VO.UserQueryVO;
import com.secshow.demo.model.VO.UserVO;
import com.secshow.demo.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private static final Log LOGGER = LogFactory.getLog(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("login")
    public UserVO login(User user){
        /*System.out.println(user);
        int res = userService.userLogin(user);
        if (res == -1)
            return "User Not Exist";
        if (res == 0)
            return "UserName Or Password error";
        return "success";*/
        return userService.userLogin(user);
    }

    @RequestMapping("register")
    public UserVO register(@RequestBody User user){
        System.out.println(user);
        return userService.userRegister(user);
//        return null;
    }

    @RequestMapping("allUser")
    public List<User> allUser(){
        return userService.getAllUsers();
    }

    @RequestMapping("updateUser")
    public String updateUser(@RequestBody User user){
        int res = userService.updateUser(user);
        if (res == 1)
            return "success";
        return "false";
    }

    @RequestMapping("delUser/{userId}")
    public String updateUser(@PathVariable Integer userId){
        int res = userService.delUser(userId);
        if (res == 1)
            return "success";
        return "false";
    }

    @RequestMapping("activeUser/{userId}")
    public String activeUser(@PathVariable Integer userId){
        int res = userService.activeUser(userId);
        if (res == 1)
            return "success";
        return "false";
    }

    @RequestMapping("queryPro")
    public List<User> queryPro(@RequestBody UserQueryVO userQueryVO){
        return userService.queryVOUser(userQueryVO);
    }
}
