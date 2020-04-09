package com.secshow.demo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Rent {
    private Integer id;

    private Integer userId;

    private Integer renterId;

    private Integer proId;

    private BigDecimal price;

    private BigDecimal deposit;

    private Integer rentDays;

    private BigDecimal rentTotalPrice;

    private BigDecimal freight;

    private Date rentStartTime;

    private Date rentEndTime;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;
}