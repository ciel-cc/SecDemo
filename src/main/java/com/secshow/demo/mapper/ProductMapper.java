package com.secshow.demo.mapper;

import com.secshow.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    Product selectByPrimaryKey(Integer id);

    /** 浏览物品 */
    List<Product> selectAll();

    List<Product> selectLikeName(String name);

    List<Product> selectByCateId(int cateId);

    List<Product> selectByType(int type);

    /** 个人物品 */
    /** 发布 */
    List<Product> selectByProviderTypeOut(int userId, int type);

    List<Product> selectByProviderTypeHadOut(int userId, int type);

    /** 入手 */
    List<Product> selectByBuyerTypeIn(int userId, int type);

    int updateByPrimaryKey(Product record);
}