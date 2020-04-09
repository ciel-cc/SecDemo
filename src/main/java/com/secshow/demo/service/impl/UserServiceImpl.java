package com.secshow.demo.service.impl;

import com.secshow.demo.mapper.UserMapper;
import com.secshow.demo.model.User;
import com.secshow.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int userLogin(User user) {
        System.out.println("servise:"+user);
        //用户是否存在，不存在返回-1
        if(userMapper.selectByPhone(user.getPhoneNumber()) == null)
            return -1;
        //返回查找结果，成功肯定为1，不成功为0
        User res = userMapper.selectByUser(user);
        System.out.println("res= " +res);
        return res == null ? 0 : 1;
    }

    @Override
    public List<User> getAllUsers(){
        return userMapper.selectAll();
    }
}
