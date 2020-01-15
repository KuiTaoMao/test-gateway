package com.ars.testgateway.tools;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import static com.alibaba.fastjson.util.IOUtils.UTF8;

public class GetFlowTest {

    public static void main(String args[]){

        String cNo = "898604241118C0067926";

        String appKey = "fxft70d59F0h3dCU";
        String appSecret = "7f598cf4cefde58e849f68b717aca1c9";
//        String appKey = "fxft25HRgv9gz98J";
//        String appSecret = "092336bb0fe3be1700d445b34ccd4764";

        // 非Form 表单，且没有body，则计算空字符串的MD5
        // 计算Content-MD5
        Charset charset = Charset.forName("utf-8");
        String str = charset.decode(UTF8.encode("")).toString();
        String md5 = getMD5(str);
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] md5Byte = md5.getBytes();
        String contentMD5 = encoder.encode(md5Byte);

        // 计算Headers
        String timestamp = String.valueOf(System.currentTimeMillis());
        String nonce = UUID.randomUUID().toString().toLowerCase();
//        String timestamp = "1502415611244";
//        String nonce = "105211ee-f5a2-49cf-a6b3-a10137420923";
        String headers = "X-Ca-Key" + ":" + appKey + "\n" +
                "X-Ca-Nonce" + ":" + nonce + "\n" +
                "X-Ca-Timestamp" + ":" + timestamp + "\n";

        // 计算Url
        String url = "http://api.iot400.com/Api/CardState?cNo=" + cNo;

        // 计算签名
        String stringToSign = contentMD5 + "\n" + headers + url;
        System.out.println("stringToSign = " + stringToSign);
        System.out.println("--------");
        String mac = getMac(stringToSign,appSecret);

        // 拼接完整的请求头
        System.out.println("完整的请求头如下:");
        System.out.println("Content-MD5="+contentMD5);
        System.out.println("X-Ca-Key="+appKey);
        System.out.println("X-Ca-Nonce="+nonce);
        System.out.println("X-Ca-Signature="+mac);
        System.out.println("X-Ca-Timestamp="+timestamp);

    }

    private static String getMac(String stringToSign, String secret) {
        String mac = null;
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            byte[] keyBytes = secret.getBytes();
            SecretKeySpec secret_key = new SecretKeySpec(keyBytes, 0, keyBytes.length, "HmacSHA256");
            sha256_HMAC.init(secret_key);

            mac = Base64.encodeBase64String(sha256_HMAC.doFinal(stringToSign.getBytes()));
        }catch (Exception e){
            e.printStackTrace();
        }

        return mac;
    }

    private static String getMD5(String str) {
        String md5 = null;
        try{
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] digest = instance.digest(str.getBytes());

            StringBuffer sb = new StringBuffer();
            for (byte b : digest){
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);

                if (hexString.length() < 2){
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            md5 = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return md5;
    }
}
