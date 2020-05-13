package com.secshow.demo.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.secshow.demo.mapper.ProductMapper;
import com.secshow.demo.model.Order;
import com.secshow.demo.model.Product;
import com.secshow.demo.model.Proimg;
import com.secshow.demo.service.ImageService;
import com.secshow.demo.service.ProductService;
import com.secshow.demo.util.Define;
import com.secshow.demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Resource
    private ImageService imageService;

    @Override
    public Product getOneProById(int proId) {
        return productMapper.selectByPrimaryKey(proId);
    }

    @Override
    public List<Product> getAllPro() {
        List<Product> list = productMapper.selectAll();
    //从数据得到的文件名加上系统可访问图片路径
        list.forEach(product -> product.getProimgs().forEach(
            proimg -> proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl())));
        return list;
}

    @Override
    public PageInfo<Product> getProPage(Integer currPage) {
        if (currPage == 0 ) currPage = 1;
        PageHelper.startPage(currPage, Define.PAGE_SIZE);
        PageInfo<Product> pageInfo = new PageInfo<>(productMapper.selectAll());
        pageInfo.getList().forEach(product -> product.getProimgs().forEach(
                proimg -> proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl())));
        return pageInfo;
    }

    @Override
    public List<Product> getProByCate(int cateId) {
        List<Product> list = productMapper.selectByCateId(cateId);
        list.forEach(product -> product.getProimgs().forEach(
                proimg -> proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl())));
        return list;
    }

    @Override
    public List<Product> getProLikeName(String name) {
        List<Product> list = productMapper.selectLikeName(name);
        list.forEach(product -> product.getProimgs().forEach(
                proimg -> proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl())));
        return list;
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
        List<Product> list = productMapper.selectByBuyerTypeIn(userId, 1);
        list.forEach( product -> { product.getProimgs().forEach(proimg ->
                proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl()));});
        return list;
    }

    @Override
    public List<Product> allPersonalRentIn(int userId) {
        List<Product> list = productMapper.selectByBuyerTypeIn(userId, 3);
        list.forEach( product -> { product.getProimgs().forEach(proimg ->
                proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl()));});
        return list;
    }

    @Override
    public List<Product> allPersonalNotSellOut(int userId) {
        List<Product> list =   productMapper.selectByProviderTypeOut(userId, 0);
        list.forEach( product -> { product.getProimgs().forEach(proimg ->
                proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl()));});
        return list;
    }

    @Override
    public List<Product> allPersonalNotRentOut(int userId) {
        List<Product> list = productMapper.selectByProviderTypeOut(userId, 2);
        list.forEach( product ->  product.getProimgs().forEach(proimg ->
                proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl())));
        return list;
    }

    @Override
    public List<Product> allPersonalHadSellOut(int userId) {
        List<Product> list =  productMapper.selectByProviderTypeHadOut(userId, 1);
        list.forEach( product ->  product.getProimgs().forEach(proimg ->
                proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl())));
        return list;
    }

    @Override
    public List<Product> allPersonalHadRentOut(int userId) {
        List<Product> list = productMapper.selectByProviderTypeHadOut(userId, 3);
        list.forEach( product ->  product.getProimgs().forEach(proimg ->
                proimg.setImgUrl(FileUtil.IMGURL + proimg.getImgUrl())));
        return list;
    }


    /********* 发布商品 ************/
    /********* 0未转卖，1已转卖，2为租赁，3已租赁, 4未租赁或转卖 ********/
    @Override
    public int insertSellPro(Product product, List<String> files) {
        System.out.println("调用添加商品");
        product.setRentOrSail((byte)0);
        product.setStatu((byte)0);
        int proRes = productMapper.insert(product);
        System.out.println("prores="+proRes);
        System.out.println(product);
        System.out.println("product id is " + product.getId());
        if (proRes != 1 || files.size() == 0)
            return proRes;
        List<Proimg> proimgList = new LinkedList<>();
        for (String fileName : files){
            Proimg proimg = buildProduct2Proimg(product, fileName);
            proimgList.add(proimg);
        }
        return imageService.insertImage(proimgList);
    }

    @Override
    public int insertRentPro(Product product, List<String> fileName) {
        product.setRentOrSail((byte)1);
        product.setStatu((byte)2);
        int proRes = productMapper.insert(product);
        System.out.println(product.getId());
        if (proRes != 1) {
            System.out.println("insert pro res != 1, proRes == " + proRes);
            return proRes;
        }
        List<Proimg> proimgList = new LinkedList<>();
        for (String name : fileName){
            Proimg proimg = buildProduct2Proimg(product, name);
            proimgList.add(proimg);
        }
        return imageService.insertImage(proimgList);
    }

    private Proimg buildProduct2Proimg(Product product, String fileName){
        Proimg proimg = new Proimg();
        proimg.setImgUrl(fileName);
        proimg.setUserId(product.getProviderUserId());
        proimg.setProId(product.getId());
        proimg.setCreateBy(product.getProviderUserId());
        proimg.setUpdateBy(product.getProviderUserId());
        return proimg;
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
