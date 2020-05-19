package com.secshow.demo.service;

import com.secshow.demo.model.MyOrder;
import com.secshow.demo.model.Order;
import com.secshow.demo.model.Rent;
import com.secshow.demo.model.VO.RentVO;

import java.util.List;

public interface OrderServer {

    List<MyOrder> getAllOrder();

    List<Rent> getAllRent();

    int insertBuyOrder(MyOrder order);

    int insertRentOrder(Rent rent);

    int deleteOrder(int orderId);

    /** 展示自己发布的转卖物品（已卖出） */
    List<MyOrder> getOrderByUserOut(Integer userId);

    /** 展示自己发布的租赁物品（已租出）*/
    /** 展示自己购入的转卖物品 */
    List<MyOrder> getOrderByUserIn(Integer userId);

    /** 展示自己购入的租赁物品 */

    /** 确认订单 -->statu: 0->1*/
    public int ensureOrder(Integer orderId);

    /** 拒绝订单 -->statu: 0->4 */
    public int refuseOrder(Integer orderId);

    /** 确认交易 -->statu: 1->2 */
    public int ensureSale(Integer orderId);

    /** 确认收货 -->statu: 2->3
     *  statu: 3完成交易*/
    public int ensureStuff(Integer orderId);

}
