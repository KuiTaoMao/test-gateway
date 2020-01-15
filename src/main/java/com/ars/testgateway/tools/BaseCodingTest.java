package com.ars.testgateway.tools;

import sun.misc.BASE64Decoder;

import java.io.*;

public class BaseCodingTest {

    public static void main(String args[]){
        BaseCodingTest test = new BaseCodingTest();
        try{
            // 编码
            byte[] BaseCoding = test.encodeBase64File("E://IdeaProjects/文档/门禁锁/福州叮咚门禁/1号声码-WMJ18101953.wav");

            String msg = new String(BaseCoding);
            System.out.println("加密："+msg);

//            File file = new File("C:/Users/maokt/Desktop/测试/base64.txt");
//            try{
//                if (file.exists() == false){
//                    file.createNewFile();
//                }
//                FileWriter fw = new FileWriter(file);
//                BufferedWriter out = new BufferedWriter(fw);
//                out.write(BaseCoding, 0, BaseCoding.length());
//                out.close();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//            System.out.println("写入文件结束");
            // 解码
            test.decoderBase64File(msg, "C:/Users/maokt/Desktop/测试/test.wav", "C:/Users/maokt/Desktop/测试/");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static byte[] encodeBase64File(String path) throws Exception{
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return org.apache.commons.codec.binary.Base64.encodeBase64(buffer);
    }

    private void decoderBase64File(String baseCoding, String targetPath, String catalogue) throws Exception{
        File file = new File(catalogue);
        if (file.exists() == false){
            file.mkdirs();
        }
        byte[] buffer = new BASE64Decoder().decodeBuffer(baseCoding);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
}
