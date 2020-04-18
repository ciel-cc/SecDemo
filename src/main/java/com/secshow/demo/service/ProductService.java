package com.secshow.demo.service;

import com.secshow.demo.model.Product;

import java.util.List;

public interface ProductService {
    /** 浏览商品 */
    List<Product> getAllPro();

    List<Product> getProByCate(int cateId);

    List<Product> getProLikeName(String name);

    List<Product> getRentPro();

    List<Product> getSellPro();

    /**个人商品
     * 买入， 租入， 转卖未卖出， 租赁未租出， 已卖出， 已租出 */
    List<Product> allPersonalBuyIn(int userId);

    List<Product> allPersonalRentIn(int userId);

    List<Product> allPersonalNotSellOut(int userId);

    List<Product> allPersonalNotRentOut(int userId);

    List<Product> allPersonalHadSellOut(int userId);

    List<Product> allPersonalHadRentOut(int userId);

    /**发布商品*/
    int insertSellPro(Product product, List<String> fileName);

    int insertRentPro(Product product);

    int insertRentPro(Product product, List<String> fileName);

    int insertBoth(Product product);

    /** 购入物品 */
    Product buyPro(int productId, int buyerUserId);

    int rentPro(int productId, int buyerUserId);

}
