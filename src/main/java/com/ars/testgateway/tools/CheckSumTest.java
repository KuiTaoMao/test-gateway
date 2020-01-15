package com.ars.testgateway.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CheckSumTest {

    public static void main(String args[]){
        String Path = "E:/IdeaProjects/文档/门禁锁/声控门禁/b01_boot(1).bin";
        File file = new File(Path);
        long fileSize = file.length();
        byte[] buffer = null;
        try(FileInputStream fi = new FileInputStream(file)){
            buffer = new byte[(int) fileSize];
            int offset = 0;
            int numRead = 0;
            while(offset < buffer.length && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0){
                offset += numRead;
            }
            //
            if (offset != buffer.length){
                throw new IOException("Could not completely read file " + file.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int checkSum = 0;
        assert buffer != null;
        for (int i = 0; i < buffer.length; i++){
            checkSum = checkSum + buffer[i];
        }

        System.out.println(checkSum);
    }
}
