package com.secshow.demo.service.impl;

import com.secshow.demo.model.Product;
import com.secshow.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Resource
    private ProductService productService;

    @Test
    void getAllPro() {
        List<Product> list = productService.getAllPro();
        for (Product p : list)
            System.out.println(p);
    }

    @Test
    void allPersonalSellOut(){
//        List<Product> list1 = productService.allPersonalNotSellOut(7);
//        List<Product> list2 = productService.allPersonalNotRentOut(7);
//        List<Product> list3 = productService.allPersonalHadSellOut(2);
//        List<Product> list4 = productService.allPersonalHadRentOut(8);
//        List<Product> list5 = productService.allPersonalBuyIn(4);
        List<Product> list6 = productService.allPersonalRentIn(5);

        for (Product product : list6)
            System.out.println(product);
    }

    @Test
    void insert(){
        Product product = new Product();
        product.setProviderUserId(7);
        product.setCreateBy(7);
        product.setUpdateBy(7);
        product.setName("price");
        product.setDeposit(new BigDecimal(542));
        String[] strings = new String[]{"tetsta", "testb"};
        List<String> list = Arrays.asList(strings);
        productService.insertSellPro(product, list);
    }
}