package com.wechat.product8001.chat.util;

import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
* @（#）:WcChatTokenUtils.java 
* @description: 获取微信token
* @author: chenyj 2019/7/24 
* @version: Version No.1
* @Copyright: 卓繁版权所有
 */
@Data
public class WcChatTokenUtils {

    /**
     * 获取微信token
     */
    private static String token;
    /**
     * 微信秘钥
     */
    private static final String appid="wx331dd9a536612860";
    /**
     * 微信密码
     */
    private static final String appsecret="2c57cc49db039757bf1206adefa13be3";
    
    public static final String charset="UTF-8";
    //获取微信tokenURL，get请求
    private static final String tokenUrl="https://api.weixin.qq.com/cgi-bin/token";
    //上次获取token时间
    private static long lastTime;


    /**
     * @description: 获取微信token
     * @author: chenyj 2019/7/24
     */
    private static void getToken(){
        Map<String, Object> map=new HashMap<>();
        map.put("grant_type","client_credential");
        map.put("appid",appid);
        map.put("secret",appsecret);
        String result = HttpRequestUtil.sendGet(tokenUrl, map, charset);
        try {
            lastTime=System.currentTimeMillis();
            JSONObject jsonObject=new JSONObject(result);
            token=jsonObject.getString("access_token");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 获取token
     * @author: chenyj 2019/7/24
     * @return
     */
    public static String getAccessToken(){
        isExpire();
        return token;
    }

    /**
     * @description: 验证token是否过期
     * @author: chenyj 2019/7/24
     * @return
     */
    private static void isExpire(){
       if (lastTime+7200*1000<System.currentTimeMillis()){
        getToken();
       }
    }

}
