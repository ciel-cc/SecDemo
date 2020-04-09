package com.secshow.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Proimg {
    private Integer id;

    private String imgUrl;

    private Integer userId;

    private Integer proId;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;

}