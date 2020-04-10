package com.secshow.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private BigDecimal stuffprice;

    private BigDecimal freight;

    private BigDecimal totalprice;

    private String statu;

    private Integer type;

    private String name;

    private String address;

    private String phone;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getStuffprice() {
        return stuffprice;
    }

    public void setStuffprice(BigDecimal stuffprice) {
        this.stuffprice = stuffprice;
    }

    public BigDecimal getfreight() {
        return freight;
    }

    public void setfreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu == null ? null : statu.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPostmethod() {
        return postmethod;
    }

    public void setPostmethod(String postmethod) {
        this.postmethod = postmethod == null ? null : postmethod.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Integer buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public Integer getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(Integer providerUserId) {
        this.providerUserId = providerUserId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}