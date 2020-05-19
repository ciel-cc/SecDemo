package com.secshow.demo.service;

import com.secshow.demo.model.Rent;

import java.util.List;

public interface RentService {

    /** 展示自己发布的租赁物品（已租出）*/
    List<Rent> getRentByUserOut(Integer userId);

    /** 展示自己购入的租赁物品 */
    List<Rent> getRentByUserIn(Integer userId);

    /** 确认订单 */
    int ensureRent(Integer rentId);
    /** 拒绝订单 */
    int refuseRent(Integer rentId);

    /** 确认交易 */
    int ensureTrans(Integer rentId);

    /** 确认收货 */
    int ensureStuff(Integer rentId);

    /** 归还物品 */
    int returnStuff(Integer rentId);

    /** 确认归还 */
    int ensureReturn(Integer rentId);

    /** 续租物品 */
    int rerentStuff(Integer rentId);

    /** 确认续租 */
    int ensureRerent(Integer rentId);

    /** 拒绝续租 */
    int refuseRerent(Integer rentId);

    /** 撤销申请 */
    int revokeRerent(Integer rentId);

    /** 超期归还 */
    int returnStuffOutTime(Integer rentId);

    /** 确认归还 */
//    int ensureReturn(Integer rentId);

    /** 超期未归还 */

}
