package com.secshow.demo.mapper;

import com.secshow.demo.model.Collect;
import java.util.List;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    Collect selectByPrimaryKey(Integer id);

    List<Collect> selectAll();

    int updateByPrimaryKey(Collect record);
}