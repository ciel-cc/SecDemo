package com.secshow.demo.service.impl;


import com.secshow.demo.mapper.ProductMapper;
import com.secshow.demo.model.Order;
import com.secshow.demo.model.Product;
import com.secshow.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllPro() {
        return productMapper.selectAll();
    }

    @Override
    public List<Product> getProByCate(int cateId) {
        return productMapper.selectByCateId(cateId);
    }

    @Override
    public List<Product> getProLikeName(String name) {
        return productMapper.selectLikeName(name);
    }

    @Override
    public List<Product> getRentPro() {
        return productMapper.selectByType(1);
    }

    @Override
    public List<Product> getSellPro() {
        return productMapper.selectByType(0);
    }

    /** 个人商品 */
    /** 物品状态statu：0未转卖，1已转卖，2为租赁，3已租赁, 4未租赁或转卖 */
    /** 物品类型rentOrSail:  1转卖， 2租赁， 3都可以 */
    @Override
    public List<Product> allPersonalBuyIn(int userId) {
        return productMapper.selectByBuyerTypeIn(userId, 1);
    }

    @Override
    public List<Product> allPersonalRentIn(int userId) {
        return productMapper.selectByBuyerTypeIn(userId, 3);
    }

    @Override
    public List<Product> allPersonalNotSellOut(int userId) {
        return productMapper.selectByProviderTypeOut(userId, 0);
    }

    @Override
    public List<Product> allPersonalNotRentOut(int userId) {
        return productMapper.selectByProviderTypeOut(userId, 2);
    }

    @Override
    public List<Product> allPersonalHadSellOut(int userId) {
        return productMapper.selectByProviderTypeHadOut(userId, 1);
    }

    @Override
    public List<Product> allPersonalHadRentOut(int userId) {
        return productMapper.selectByProviderTypeHadOut(userId, 3);
    }


    /********* 发布商品 ************/
    /********* 0未转卖，1已转卖，2为租赁，3已租赁, 4未租赁或转卖 ********/
    @Override
    public int insertSellPro(Product product) {
        product.setRentOrSail((byte)0);
        product.setStatu((byte)0);
        return productMapper.insert(product);
    }

    @Override
    public int insertRentPro(Product product) {
        product.setRentOrSail((byte)1);
        product.setStatu((byte)2);
        return productMapper.insert(product);
    }

    @Override
    public int insertBoth(Product product) {
        product.setRentOrSail((byte)2);
        product.setStatu((byte)4);
        return productMapper.insert(product);
    }

    @Override
    public Product buyPro(int productId, int buyerUserId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        System.out.println(product);
        product.setStatu((byte)1);
        product.setBuyerUserId(buyerUserId);
        product.setIsDeleted(1);
        product.setUpdateBy(product.getBuyerUserId());
        int prores = productMapper.updateByPrimaryKey(product);
        return product;
    }

    @Override
    public int rentPro(int productId, int buyerUserId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        product.setBuyerUserId(buyerUserId);
        product.setStatu((byte)3);
        product.setIsDeleted(1);
        product.setUpdateBy(product.getBuyerUserId());
        int prores = productMapper.updateByPrimaryKey(product);
        return prores;
    }
}
