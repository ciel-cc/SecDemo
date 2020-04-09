package com.secshow.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private Integer id;

    private String name;

    private Integer amount;

    private Double price;

    private Double deposit;

    private String detail;

    private Integer cateId;

    private Integer providerUserId;

    private Integer buyerUserId;

    /** 物品状态：
     * 1已转卖，2为租赁，3已租赁, 4未租赁或转卖 */
    private Byte statu;

    /** 物品类型:  1转卖， 2租赁， 3都可以 */
    private Byte rentOrSail;

    private Date releaseTime;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    private Integer isDeleted;

    private String img;

    private String ownerName;

    private String ownerPhone;

    private String ownerAddress;

}