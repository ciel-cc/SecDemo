package com.secshow.demo.mapper;

import com.secshow.demo.model.Proimg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProimgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Proimg record);

    Proimg selectByPrimaryKey(Integer id);

    List<Proimg> selectAll();

    int updateByPrimaryKey(Proimg record);
}