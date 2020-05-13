package com.secshow.demo.service.impl;

import com.secshow.demo.mapper.UserMapper;
import com.secshow.demo.model.User;
import com.secshow.demo.model.VO.UserVO;
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
    public UserVO userLogin(User user) {
        System.out.println("servise:"+user);
        //用户是否存在，不存在返回-1
        UserVO userVO = new UserVO();
        if(userMapper.selectByPhone(user.getPhoneNumber()) == null){
            userVO.setReturnMsg("改手机号尚未注册");
            return userVO;
        }
        //返回查找结果，成功肯定为1，不成功为0
        User res = userMapper.selectByUser(user);
        System.out.println("res= " +res);
        if (res == null)
            userVO.setReturnMsg("手机号和密码不匹配");
        else
            userVO.setReturnMsg("欢迎");
        userVO.setUser(res);
        return userVO;
    }

    @Override
    public UserVO userRegister(User user) {
        System.out.println("reg user "+user);
        UserVO userVO = new UserVO();
        if (userMapper.selectByPhone(user.getPhoneNumber()) != null){
            userVO.setReturnMsg("该手机号已注册");
            return userVO;
        }
        int res = userMapper.insert(user);
        if (res == 1)
            userVO.setReturnMsg("成功注册");
        else
            userVO.setReturnMsg("注册失败");
        System.out.println("after insert : "+ user);
        userVO.setUser(user);
        return userVO;
    }

    @Override
    public List<User> getAllUsers(){
        return userMapper.selectAll();
    }
}
