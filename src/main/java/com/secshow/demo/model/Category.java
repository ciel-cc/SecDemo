package com.secshow.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Category {
    private Integer id;

    private String name;

    private String detail;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;

    private Integer isDeleted;

}