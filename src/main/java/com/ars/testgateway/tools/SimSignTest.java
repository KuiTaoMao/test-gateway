package com.ars.testgateway.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SimSignTest {

    public static void main(String args[]){

        // 随机生成8为数字
        Random random = new Random();
        String result = "";
        for (int i=0; i < 8; i++){
            result += random.nextInt(10);
        }
//        System.out.println(result);

        String time = new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date());
        String requesttime = time + result;
        System.out.println("requesttime：" + requesttime);
        String key = "898604301118c0023130";
        String month = new SimpleDateFormat("yyyyMM") .format(new Date());
        String sequence = "2419vhn502" + requesttime + key + month;
//        System.out.println("sequence:" + sequence);


        // 计算MD5
        try{
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] digest = instance.digest(sequence.getBytes());

            StringBuffer sb = new StringBuffer();
            for (byte b : digest){
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);

                if (hexString.length() < 2){
                    hexString = "0" + hexString;
                }

                sb.append(hexString);
            }
            System.out.println("sign:" + sb.toString());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

    }
}
