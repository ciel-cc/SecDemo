package com.secshow.demo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Rent {
    private Integer id;

    private Integer proId;

    private BigDecimal unitprice;

    private BigDecimal stuffprice;

    private BigDecimal freight;

    private BigDecimal deposit;

    private BigDecimal totalprice;

    private Integer rentDays;

    private Date rentStartTime;

    private Date rentEndTime;

    private Integer statu;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;

    private String name;

    private String address;

    private String phone;

    private String postmethod;

    private Date orderTime;

    private Integer buyerUserId;

    private Integer providerUserId;

}