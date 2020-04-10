package com.secshow.demo.model.VO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RentVO {

    //物品价格
    private BigDecimal stuffprice;

    //租赁单价
    private BigDecimal unitprice;

    //运费
    private BigDecimal freight;

    //总价格
    private BigDecimal totalprice;

    //押金
    private BigDecimal deposit;

    //租赁天数
    private Integer rentDays;

    private Date rentStartTime;

    private Date rentEndTime;

    private String name;

    private String address;

    private String phone;

    private String postmethod;

    //买家ID
    private Integer buyerUserId;

    //卖家ID
    private Integer providerUserId;

    //商品ID
    private Integer proId;

}
