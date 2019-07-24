package com.wechat.product8001.chat.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author chenyj
 * @Description 验证是否可以接入微信
 * @Date create by 2019/7/23 20:44
 * 陈银杰专属测试
 */
@Data
public class CheckSignature {

    private static final String token = "chenyinjie";

    private String signature;

    private String timestamp;

    private String nonce;

    private String echostr;

    /**
     * 1）将token、timestamp、nonce三个参数进行字典序排序
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * @description:
     * @author: chenyj 2019/7/24
     */
    public boolean check(){
        String[] strs=new String[]{token,timestamp,nonce};
        Arrays.sort(strs);
        String str= strs[0] +strs[1]+strs[2];
        String mysig=sha1(str);
        return  mysig.equalsIgnoreCase(signature);
    }

    /**
     * @description: 验证加密算法
     * @author: chenyj 2019/7/24
     * @param str
     * @return
     */
    private static String sha1(String str) {
        try {
            //获取一个加密对象
            MessageDigest messageDigest=MessageDigest.getInstance("sha1");
            //加密
            byte[] digest = messageDigest.digest(str.getBytes());
            //处理
            char[] chars={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuffer sbf=new StringBuffer();
            for (byte d:digest){
                sbf.append(chars[(d>>4)&15]);
                sbf.append(chars[d&15]);
            }
            return sbf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
