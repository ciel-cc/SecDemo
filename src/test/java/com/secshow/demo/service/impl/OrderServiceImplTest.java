package com.secshow.demo.service.impl;

import com.secshow.demo.model.MyOrder;
import com.secshow.demo.model.Order;
import com.secshow.demo.model.VO.RentVO;
import com.secshow.demo.service.OrderServer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderServiceImplTest {

    @Resource
    private OrderServer orderServer;

    @Test
    void insertBuyOrder() {
        MyOrder order = new MyOrder();
        order.setProId(6);
        order.setProviderUserId(7);
        order.setBuyerUserId(5);
        order.setTotalprice(new BigDecimal(234));
        order.setName("xiao a");
        order.setPhone("1237886");
        order.setStuffprice(new BigDecimal(220));
        int res = orderServer.insertBuyOrder(order);
        System.out.println(res);
    }

    @Test
    void insertRentOrder() {
        RentVO order = new RentVO();
        order.setProId(5);
        order.setProviderUserId(2);
        order.setBuyerUserId(5);
        order.setTotalprice(new BigDecimal(234));
        order.setDeposit(new BigDecimal(24));
        order.setName("aha");
        order.setPhone("14322227886");
        order.setStuffprice(new BigDecimal(220));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2020-2-4");
            order.setRentStartTime(date);
            Date date2 = sdf.parse("2020-2-9");
            order.setRentEndTime(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int res = orderServer.insertRentOrder(order);
        System.out.println(res);
    }

    @Test
    void deleteOrder() {
    }
}