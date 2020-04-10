package com.secshow.demo.mapper;

import com.secshow.demo.model.Rent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rent record);

    Rent selectByPrimaryKey(Integer id);

    List<Rent> selectAll();

    int updateByPrimaryKey(Rent record);
}