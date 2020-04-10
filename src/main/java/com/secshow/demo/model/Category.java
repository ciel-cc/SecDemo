package com.secshow.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer id;

    private String name;

    private Date updateTime;

    private String createBy;

    private Date updateBy;

    private Integer isDeleted;

}