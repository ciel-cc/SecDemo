package com.secshow.demo.service.impl;

import com.secshow.demo.model.Proimg;
import com.secshow.demo.service.ImageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ImageServiceImplTest {

    @Resource
    private ImageService imageService;

    @Test
    void insertImage() {
        Proimg proimg1 = new Proimg();
        proimg1.setProId(2);
        proimg1.setUserId(5);
        proimg1.setImgUrl("aaa");
        Proimg proimg2 = new Proimg();
        proimg2.setProId(2);
        proimg2.setUserId(5);
        proimg2.setImgUrl("bbb");
        Proimg proimg3 = new Proimg();
        proimg3.setProId(2);
        proimg3.setUserId(5);
        proimg3.setImgUrl("ccc");
        List<Proimg> list = new LinkedList<>();
        list.add(proimg1);
        list.add(proimg2);
        list.add(proimg3);
        for (Proimg proimg : list)
            System.out.println(proimg);
        int res = imageService.insertImage(list);
        System.out.println(res);
    }
}