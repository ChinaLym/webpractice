package com.edeclare.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {

    /**
     * 将 content 写到file中
     * @param file
     * @param content
     * @throws Exception 
     */
    public static void writeFile(File file, byte[] content) throws Exception {
    	FileOutputStream fos = new FileOutputStream(file);
        fos.write(content);
        fos.close();
            
    }
    
    /**
     * 获取文件名的后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName) {
        if(fileName.indexOf(".") == -1) {
            return "";
        }
        int dotIndex = fileName.indexOf(".");
        String result = fileName.substring(dotIndex, fileName.length());
        return result;
    }
    
    /*public static void main(String[] args) {
        System.out.println(FileUtil.getSuffix("abc"));
        System.out.println(FileUtil.getSuffix("abc.png"));
    }*/
}
