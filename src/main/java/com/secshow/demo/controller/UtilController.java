package com.secshow.demo.controller;

import com.secshow.demo.model.Product;
import com.secshow.demo.util.FileNameUtil;
import com.secshow.demo.util.FileUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("util")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UtilController {

    @RequestMapping("uploadImg")
    public String uploadImg(@RequestParam("fileList") List<MultipartFile> list, Product product){
        for (int i = 0; i < list.size(); i++) {
//            String uuidFileName = FileNameUtil.getFileName(list.get(i).getOriginalFilename());
//            System.out.println("origin文件名：" + list.get(i).getOriginalFilename());
            System.out.println("文件名：" +  list.get(i).getOriginalFilename());
            boolean res = FileUtil.upload(list.get(i), "D:\\testImg\\",  list.get(i).getOriginalFilename());
            if (!res)
                return "upload error";
        }
        return "ok";
    }
    @RequestMapping("uploadOneImg")
    public String uploadImg(@RequestParam("file") MultipartFile list){
        System.out.println(list);
        return "ok";
    }
}
