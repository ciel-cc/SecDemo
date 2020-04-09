package com.secshow.demo.mapper;

import com.secshow.demo.model.Proimg;
import java.util.List;

public interface ProimgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Proimg record);

    Proimg selectByPrimaryKey(Integer id);

    List<Proimg> selectAll();

    int updateByPrimaryKey(Proimg record);
}