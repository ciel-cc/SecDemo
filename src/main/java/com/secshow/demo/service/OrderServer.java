package com.secshow.demo.service;

import com.secshow.demo.model.MyOrder;
import com.secshow.demo.model.Order;
import com.secshow.demo.model.Rent;
import com.secshow.demo.model.VO.RentVO;

import java.util.List;

public interface OrderServer {

    List<MyOrder> getAllOrder();

    int insertBuyOrder(MyOrder order);

    int insertRentOrder(Rent rent);

    int deleteOrder(int orderId);
}
