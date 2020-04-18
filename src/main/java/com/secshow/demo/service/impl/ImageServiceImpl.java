package com.secshow.demo.service.impl;

import com.secshow.demo.mapper.ProimgMapper;
import com.secshow.demo.model.Proimg;
import com.secshow.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ProimgMapper proimgMapper;

    @Override
    public int insertImage(List<Proimg> list) {
        System.out.println("insertImage");
        int res = 0;
        for (Proimg proimg : list){
            proimgMapper.insert(proimg);
            System.out.println("proimg: " + proimg.getId());
            res++;
        }
        return res;
    }

    @Override
    public int insertImage(Proimg proimg) {
        return proimgMapper.insert(proimg);
    }
}
