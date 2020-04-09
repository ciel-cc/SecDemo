package com.secshow.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Address {
    private Integer id;

    private Integer userId;

    private String receiverName;

    private String receiverPhone;

    private Integer provinceId;

    private String provinceName;

    private Integer cityId;

    private String cityName;

    private Integer countryId;

    private String countryName;

    private String detail;

    private String postalCode;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;

}