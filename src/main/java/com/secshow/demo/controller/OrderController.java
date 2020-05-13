package com.secshow.demo.controller;

import com.secshow.demo.model.MyOrder;
import com.secshow.demo.model.Rent;
import com.secshow.demo.service.OrderServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {

    @Resource
    private OrderServer orderServer;

    @RequestMapping("allOrder")
    public List<MyOrder> allOrder(){
        return orderServer.getAllOrder();
    }

    @RequestMapping("addBuyOrder")
    public String addBuyOrder(@RequestBody MyOrder order){
        System.out.println(order);
        int res = orderServer.insertBuyOrder(order);
        if (res == 1)
            return "success";
        return "error";
    }

    @RequestMapping("addRentOrder")
    public String addBuyOrder(@RequestBody Rent rent){
        System.out.println(rent);
        int res = orderServer.insertRentOrder(rent);
        if (res == 1)
            return "success";
        return "error";
    }


}
