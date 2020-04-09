package com.secshow.demo.mapper;

import com.secshow.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    User selectByPhone(String phone);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByUser(User user);
}