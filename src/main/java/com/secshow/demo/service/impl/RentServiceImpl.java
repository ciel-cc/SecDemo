package com.secshow.demo.service.impl;

import com.secshow.demo.mapper.RentMapper;
import com.secshow.demo.model.Rent;
import com.secshow.demo.service.RentService;
import com.secshow.demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentMapper rentMapper;

    /** 展示自己发布的租赁物品（已租出）*/
    @Override
    public List<Rent> getRentByUserOut(Integer userId) {
        List<Rent> list = rentMapper.selectRentOut(userId);
        list.forEach( rent ->  rent.getProimgs().forEach(proimg ->
                proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl())));
        return list;
    }

    /** 展示自己购入的租赁物品 */
    @Override
    public List<Rent> getRentByUserIn(Integer userId) {
        List<Rent> list = rentMapper.selectRentIn(userId);
        list.forEach( rent ->  rent.getProimgs().forEach(proimg ->
                proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl())));
        return list;
    }

    /** 确认订单 --> statu:1*/
    @Override
    public int ensureRent(Integer rentId) {
        return rentMapper.updateStatu(rentId, 1);
    }

    /** 拒绝订单 */
    @Override
    public int refuseRent(Integer rentId) {
        return rentMapper.updateStatu(rentId, 10);
    }

    /** 确认交易 */
    @Override
    public int ensureTrans(Integer rentId) {
        return rentMapper.updateStatu(rentId, 2);
    }

    /** 确认收货 */
    @Override
    public int ensureStuff(Integer rentId) {
        return rentMapper.updateStatu(rentId, 3);
    }

    /** 归还物品 */
    @Override
    public int returnStuff(Integer rentId) {
        return rentMapper.updateStatu(rentId, 4);
    }

    /** 确认归还 */
    @Override
    public int ensureReturn(Integer rentId) {
        return rentMapper.updateStatu(rentId, 5);
    }

    /** 续租物品 */
    @Override
    public int rerentStuff(Integer rentId) {
        return rentMapper.updateStatu(rentId, 6);
    }

    /** 确认续租 */
    @Override
    public int ensureRerent(Integer rentId) {
        //增加续租时间
        return rentMapper.updateStatu(rentId, 3);
    }

    /** 拒绝续租 */
    @Override
    public int refuseRerent(Integer rentId) {
        return rentMapper.updateStatu(rentId, 3);
    }

    /** 撤销申请 */
    @Override
    public int revokeRerent(Integer rentId) {
        return rentMapper.updateStatu(rentId, 3);
    }

    /** 超期归还 */
    @Override
    public int returnStuffOutTime(Integer rentId) {
        return rentMapper.updateStatu(rentId, 8);
    }
    /** 确认归还 */
    /** 超期未归还 */
}
