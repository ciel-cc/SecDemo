package com.secshow.demo.util;

import java.util.UUID;

public class FileNameUtil {
    /**
     * 获取文件后缀
     */
    private static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成文件名
     */
    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成新的文件名
     */
    public static String getFileName(String fileOriginName){
        return getUUID() + FileNameUtil.getSuffix(fileOriginName);
    }
}
