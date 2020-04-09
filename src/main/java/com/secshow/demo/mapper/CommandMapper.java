package com.secshow.demo.mapper;

import com.secshow.demo.model.Command;
import java.util.List;

public interface CommandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Command record);

    Command selectByPrimaryKey(Integer id);

    List<Command> selectAll();

    int updateByPrimaryKey(Command record);
}