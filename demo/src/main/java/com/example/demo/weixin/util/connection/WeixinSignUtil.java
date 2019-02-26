/**
   * 检测signature，标识该请求来自于微信
 */

package com.example.demo.weixin.util.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Component
public class WeixinSignUtil {

    //控制台输出日志信息所在的类
    public static Logger logger = LoggerFactory.getLogger(WeixinSignUtil.class);
    //与微信公众号号中配置的token相同
    public static String token = "weixin";

    public boolean checkSignature(String signature,String timestamp,String nonce){
        String[] arr = new String[]{token,timestamp,nonce};
        //将tokec，timestamp,nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for(int i = 0 ; i<arr.length; i++){
            content.append(arr[i]);
        }

        //MessageDigest类为应用程序提供信息摘要算法的功能
        MessageDigest md = null;
        String tmpStr = null;

        try {
            //MessageDigest通过getIntance函数进行sha-加密
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        logger.info("------正在微信签名加密认证-----");
        content = null;
        //将sha1加密后的字符串与signature对比，标识该请求来自于微信
        return tmpStr !=null ? tmpStr.equals(signature.toUpperCase()) : false ;

    }

    //将字节数组转变为十六进制字符串
    public static String byteToStr(byte [] digest){
        String tmpStr = "";
        for (int i = 0 ;i < digest.length ; i++){
            tmpStr += byteToHexStr(digest[i]);
        }
        return tmpStr;
    }

    //将字节转变为十六进制字符串
    public static String byteToHexStr(byte c){
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(c >>> 4) & 0X0F];
        tempArr[1] = Digit[c & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
