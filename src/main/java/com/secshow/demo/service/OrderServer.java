package com.secshow.demo.service;

import com.secshow.demo.model.MyOrder;
import com.secshow.demo.model.Order;
import com.secshow.demo.model.VO.RentVO;

public interface OrderServer {

    int insertBuyOrder(MyOrder order);

    int insertRentOrder(RentVO rentVO);

    int deleteOrder(int orderId);
}
