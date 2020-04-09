package com.secshow.demo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    private Integer id;

    private BigDecimal stuffprice;

    private BigDecimal freightprice;

    private BigDecimal totalprice;

    private String statu;

    private String name;

    private String address;

    private String phone;

    private String postmethod;

    private Date orderTime;

    private Integer userId;

    private Integer proId;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}