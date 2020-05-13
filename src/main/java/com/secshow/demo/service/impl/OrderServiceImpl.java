package com.secshow.demo.service.impl;

import com.secshow.demo.mapper.MyOrderMapper;
import com.secshow.demo.mapper.OrderMapper;
import com.secshow.demo.mapper.RentMapper;
import com.secshow.demo.model.MyOrder;
import com.secshow.demo.model.Order;
import com.secshow.demo.model.Product;
import com.secshow.demo.model.Rent;
import com.secshow.demo.model.VO.RentVO;
import com.secshow.demo.service.OrderServer;
import com.secshow.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Provider;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderServer {

    @Autowired
    private MyOrderMapper orderMapper;

    @Autowired
    private RentMapper rentMapper;

    @Resource
    private ProductService productService;

    @Override
    public List<MyOrder> getAllOrder() {
        return orderMapper.selectAll();
    }

    @Override
    public int insertBuyOrder(MyOrder order) {
        Product product = productService.buyPro(order.getProId(), order.getBuyerUserId());
        order.setType(0);
        order.setProviderUserId(product.getProviderUserId());
        order.setCreateBy(order.getBuyerUserId());
        order.setUpdateBy(order.getBuyerUserId());
        return orderMapper.insert(order);
    }

    @Override
    public int insertRentOrder(Rent rent) {
        productService.rentPro(rent.getProId(), rent.getBuyerUserId());
        rent.setCreateBy(rent.getBuyerUserId());
        rent.setUpdateBy(rent.getBuyerUserId());
        return rentMapper.insert(rent);
//        MyOrder order = buildRentVO2Order(rentVO);
//        order.setType(1);
//        return orderMapper.insert(order);
    }

    @Override
    public int deleteOrder(int orderId) {
        return 0;
    }

    private MyOrder buildRentVO2Order(RentVO rentVO){
        MyOrder order = new MyOrder();
        order.setType(1);
        order.setFreight(rentVO.getFreight());
        order.setStuffprice(rentVO.getStuffprice());
        order.setTotalprice(rentVO.getTotalprice());
        order.setBuyerUserId(rentVO.getBuyerUserId());
        order.setProviderUserId(rentVO.getProviderUserId());
        order.setName(rentVO.getName());
        order.setAddress(rentVO.getAddress());
        order.setCreateBy(rentVO.getBuyerUserId());
        order.setPhone(rentVO.getPhone());
        order.setPostmethod(rentVO.getPostmethod());
        order.setProId(rentVO.getProId());
        order.setCreateBy(rentVO.getBuyerUserId());
        order.setUpdateBy(rentVO.getBuyerUserId());
        return order;
    }

    private Rent buildRentVO2Rent(RentVO rentVO){
        Rent rent = new Rent();
        rent.setProId(rentVO.getProId());
        /*rent.setUserId(rentVO.getProviderUserId());
        rent.setRenterId(rentVO.getProviderUserId());
        rent.setDeposit(rentVO.getDeposit());
        rent.setFreight(rentVO.getFreight());
        rent.setPrice(rentVO.getUnitprice());
        rent.setRentTotalPrice(rentVO.getTotalprice());*/
        rent.setRentDays(rentVO.getRentDays());
        rent.setRentStartTime(rentVO.getRentStartTime());
        rent.setRentEndTime(rentVO.getRentEndTime());
        rent.setUpdateBy(rentVO.getBuyerUserId());
        rent.setCreateBy(rentVO.getBuyerUserId());
        return rent;
    }
}
