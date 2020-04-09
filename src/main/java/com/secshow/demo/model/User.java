package com.secshow.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;

    private String username;

    private String password;

    private Integer sex;

    private String email;

    private String phoneNumber;

    private String phone;

    private Integer type;
}