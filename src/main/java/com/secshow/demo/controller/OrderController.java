package com.secshow.demo.controller;

import com.secshow.demo.model.MyOrder;
import com.secshow.demo.model.Rent;
import com.secshow.demo.service.OrderServer;
import com.secshow.demo.service.RentService;
import org.omg.CORBA.INTERNAL;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController {

    @Resource
    private OrderServer orderServer;

    @Resource
    private RentService rentService;

    @RequestMapping("allOrder")
    public List<MyOrder> allOrder(){
        return orderServer.getAllOrder();
    }

    @RequestMapping("allRent")
    public List<Rent> allRent(){
        return orderServer.getAllRent();
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

    /** 展示自己发布的转卖物品（已卖出） */
    @RequestMapping("orderOut/{userId}")
    public List<MyOrder> allOrderOut(@PathVariable Integer userId){
        return orderServer.getOrderByUserOut(userId);
    }
    /** 展示自己发布的租赁物品（已租出）*/
    @RequestMapping("rentOut/{userId}")
    public List<Rent> allRentOut(@PathVariable Integer userId) {
        return rentService.getRentByUserOut(userId);
    }

        /** 展示自己购入的转卖物品 */
    @RequestMapping("orderIn/{userId}")
    public List<MyOrder> allOrderIn(@PathVariable Integer userId){
        return orderServer.getOrderByUserIn(userId);
    }
    /** 展示自己购入的租赁物品 */
    @RequestMapping("rentIn/{userId}")
    public List<Rent> allRentIn(@PathVariable Integer userId) {
        return rentService.getRentByUserIn(userId);
    }


    /***********************************  订单状态的改变   ********************************************/
    /** 确认订单 */
    @RequestMapping("ensureOrder/{orderId}")
    public String ensureOrder(@PathVariable Integer orderId){
        int res = orderServer.ensureOrder(orderId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 拒绝订单 */
    @RequestMapping("refuseOrder/{orderId}")
    public String refuseOrder(@PathVariable Integer orderId){
        int res = orderServer.refuseOrder(orderId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 确认交易 */
    @RequestMapping("ensureSale/{orderId}")
    public String ensureSale(@PathVariable Integer orderId){
        int res = orderServer.ensureSale(orderId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 确认收货 */
    @RequestMapping("ensureStuff/{orderId}")
    public String ensureStuff(@PathVariable Integer orderId){
        int res = orderServer.ensureStuff(orderId);
        if (res == 1)
            return "success";
        return "false";
    }

    /********************************* 租赁 ***************************************/
    /** 确认订单 */
    @RequestMapping("ensureRent/{rentId}")
    public String ensureRent(@PathVariable Integer rentId){
        int res = rentService.ensureRent(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 拒绝订单 */
        @RequestMapping("refuseRent/{rentId}")
    public String refuseRent(@PathVariable Integer rentId){
        int res = rentService.refuseRent(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 确认交易 */
    @RequestMapping("ensureRentTrans/{rentId}")
    public String ensureRentTrans(@PathVariable Integer rentId){
        int res = rentService.ensureTrans(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 确认收货 */
    @RequestMapping("ensureStuffRent/{rentId}")
    public String ensureStuffRent(@PathVariable Integer rentId){
        int res = rentService.ensureStuff(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 归还物品 */
    @RequestMapping("returnStuff/{rentId}")
    public String returnStuff(@PathVariable Integer rentId){
        int res = rentService.returnStuff(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 确认归还 */
    @RequestMapping("ensureReturn/{rentId}")
    public String ensureReturn(@PathVariable Integer rentId){
        int res = rentService.ensureReturn(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 续租物品 */
    @RequestMapping("rerentStuff/{rentId}")
    public String rerentStuff(@PathVariable Integer rentId){
        int res = rentService.rerentStuff(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 确认续租 */
    @RequestMapping("ensureRerent/{rentId}")
    public String ensureRerent(@PathVariable Integer rentId){
        int res = rentService.ensureRerent(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 拒绝续租 */
    @RequestMapping("refuseRerent/{rentId}")
    public String refuseRerent(@PathVariable Integer rentId){
        int res = rentService.refuseRerent(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 撤销申请 */
    @RequestMapping("revokeRerent/{orderId}")
    public String revokeRerent(@PathVariable Integer rentId){
        int res = rentService.revokeRerent(rentId);
        if (res == 1)
            return "success";
        return "false";
    }
    /** 超期归还 */
    @RequestMapping("returnStuffOutTime/{rentId}")
    public String returnStuffOutTime(@PathVariable Integer rentId){
        int res = rentService.returnStuffOutTime(rentId);
        if (res == 1)
            return "success";
        return "false";

    }
    /** 确认归还 */
    /** 超期未归还 */


}
