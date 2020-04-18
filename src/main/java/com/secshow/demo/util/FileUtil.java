package com.secshow.demo.util;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static final String  IMGURL = "http://192.168.0.103:8081/testImg/";

    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @param fileName 源文件名
     * @return
     */
    public static boolean upload(MultipartFile file, String path, String fileName){
        //生成新的文件名
//        String realPath = path + "/" + FileNameUtil.getFileName(fileName);
        String realPath = path + "/" + fileName;
        File dest = new File(realPath);

        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
