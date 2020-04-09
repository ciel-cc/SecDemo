package com.secshow.demo.mapper;

import com.secshow.demo.model.Rent;
import java.util.List;

public interface RentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rent record);

    Rent selectByPrimaryKey(Integer id);

    List<Rent> selectAll();

    int updateByPrimaryKey(Rent record);
}