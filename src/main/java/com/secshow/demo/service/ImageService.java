package com.secshow.demo.service;

import com.secshow.demo.model.Proimg;

import java.util.List;

public interface ImageService {

    int insertImage(List<Proimg> list);

    int insertImage(Proimg proimg);
}
