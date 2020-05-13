package com.secshow.demo.controller;

import com.github.pagehelper.PageInfo;
import com.secshow.demo.model.Product;
import com.secshow.demo.service.ProductService;
import com.secshow.demo.util.FileNameUtil;
import com.secshow.demo.util.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("pro")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProController {

    @Resource
    private ProductService productService;

    /**************************** 浏览物品 ***************************/
    @RequestMapping("onePro/{proId}")
    public Product proById(@PathVariable int proId){
        return productService.getOneProById(proId);
    }

    @RequestMapping("allPro")
    public List<Product> allPro(){
        return productService.getAllPro();
    }

    @RequestMapping("proPage/{currPage}")
    public PageInfo<Product> allProPage(@PathVariable Integer currPage){
        return productService.getProPage(currPage);
    }



    /** 根据类型 */
    @RequestMapping("proByCate/{cateId}")
    public List<Product> proByCate(@PathVariable int cateId){
        return productService.getProByCate(cateId);
    }

    /** 所有租赁物品 */
    @RequestMapping("allRent")
    public List<Product> allRentPro(){
        return productService.getRentPro();
    }

    /** 所有转卖物品 */
    @RequestMapping("allSell")
    public List<Product> allSellPro(){
        return productService.getSellPro();
    }

    /** 模糊查询 */
    @RequestMapping("likeName")
    public List<Product> likequery(@RequestParam String name){
        System.out.println("like name" + name);
        return productService.getProLikeName(name);
    }


    /************************8** 浏览个人物品 **************************/
    /** 展示自己发布的转卖物品（未卖出） */
    @RequestMapping("stuffNotSell/{userId}")
    public List<Product> stuffNotSell(@PathVariable String userId){
        return productService.allPersonalNotSellOut(Integer.valueOf(userId));
    }

    /** 展示自己发布的转卖物品（已卖出） */
    @RequestMapping("stuffSell/{userId}")
    public List<Product> stuffSell(@PathVariable String userId){
        return productService.allPersonalHadSellOut(Integer.valueOf(userId));
    }

    /** 展示自己发布的租赁物品（未租出）*/
    @RequestMapping("stuffNotRent/{userId}")
    public List<Product> stuffNotRent(@PathVariable String userId){
        return productService.allPersonalNotRentOut(Integer.valueOf(userId));
    }

    /** 展示自己发布的租赁物品（已租出）*/
    @RequestMapping("stuffRent/{userId}")
    public List<Product> stuffRent(@PathVariable String userId){
        return productService.allPersonalHadRentOut(Integer.valueOf(userId));
    }

    /** 展示自己购入的转卖物品 */
    @RequestMapping("stuffBuyIn/{userId}")
    public List<Product> stuffBuyIn(@PathVariable String userId){
        return productService.allPersonalBuyIn(Integer.valueOf(userId));
    }

    /** 展示自己购入的租赁物品 */
    @RequestMapping("stuffRentIn/{userId}")
    public List<Product> stuffRentIn(@PathVariable String userId){
        return productService.allPersonalRentIn(Integer.valueOf(userId));
    }

    /************************ 发布物品 *****************************/
    @RequestMapping("addSell")
    public String addSell(@RequestParam("fileList") List<MultipartFile> list, Product product){
        System.out.println(product);
        List<String> fileNames = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String uuidFileName = FileNameUtil.getFileName(list.get(i).getOriginalFilename());
//            System.out.println("origin文件名：" + list.get(i).getOriginalFilename());
            System.out.println("文件名：" +  list.get(i).getOriginalFilename());
            boolean res = FileUtil.upload(list.get(i), "D:\\testImg\\", uuidFileName);
            if (!res)
                return "upload img error";
            fileNames.add(uuidFileName);
        }

        int res = productService.insertSellPro(product, fileNames);
        if (res >= 1){
            return "success";
        }
        return "error insert product";
    }

    @RequestMapping("addRent")
    public String addRent(@RequestParam("fileList") List<MultipartFile> list, Product product){
        System.out.println(product);
        List<String> fileNames = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String uuidFileName = FileNameUtil.getFileName(list.get(i).getOriginalFilename());
            System.out.println("文件名：" +  list.get(i).getOriginalFilename());
            boolean res = FileUtil.upload(list.get(i), "D:\\testImg\\", uuidFileName);
            if (!res)
                return "upload img error";
            fileNames.add(uuidFileName);
        }
        int res = productService.insertRentPro(product, fileNames);
        if (res >= 1)
            return "success";
        return "error";
    }

    /**可转卖可租赁*/
    @RequestMapping("addBoth")
    public String addBoth(@RequestBody Product product){
        int res = productService.insertRentPro(product);
        if (res == 1)
            return "success";
        return "error";
    }

    /************************ 入物品 *****************************/
    /** 买入物品 */
    /*@RequestMapping("buyStuff")
    public String buyStuff(@RequestBody Product product, int userId){
        System.out.println(product);
        System.out.println(userId);
        return "ok";
        *//*int res = productService.buyPro(product.getBuyerUserId());
        if (res == 1)
            return "success";
        return "error";*//*
    }*/
    /** 租赁物品 */
}
