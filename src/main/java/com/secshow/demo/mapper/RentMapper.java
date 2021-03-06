package com.secshow.demo.mapper;

import com.secshow.demo.model.Rent;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface RentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rent record);

    Rent selectByPrimaryKey(Integer id);

    List<Rent> selectAll();

    int updateByPrimaryKey(Rent record);

    List<Rent> selectRentOut(Integer id);

    List<Rent> selectRentIn(Integer id);

    int updateStatu(Integer rentId, Integer statu);
}