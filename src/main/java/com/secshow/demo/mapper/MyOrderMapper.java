package com.secshow.demo.mapper;

import com.secshow.demo.model.MyOrder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface MyOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyOrder record);

    MyOrder selectByPrimaryKey(Integer id);

    List<MyOrder> selectAll();

    int updateByPrimaryKey(MyOrder record);
}