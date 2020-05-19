package com.secshow.demo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class MyOrder {
    private Integer id;

    private BigDecimal unitprice;

    private BigDecimal stuffprice;
    //运费
    private BigDecimal freight;
    //押金
    private BigDecimal deposit;

    private BigDecimal totalprice;

    private String statu;

    private Integer type;

    private String name;

    private String address;

    private String phone;

    /** 0线下交易，1邮寄 */
    private String postmethod;

    private Date orderTime;

    private Integer buyerUserId;

    private Integer providerUserId;

    private Integer proId;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;

    private Date rentStartTime;

    private Date rentEndTime;

    private Product product;

    private User buyerUser;

    private User providerUser;

    private List<Proimg> proimgs;

    private String proName;

    private String proDetail;
}