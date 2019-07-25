package com.wechat.product8001.chat.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenyj
 * @Description 微信公众号统一处理util
 * @Date create by 2019/7/23 22:02
 * 陈银杰专属测试
 */
public class WeChatUtils {

    /**
     * 自定义菜单接口
     */
    private static final String buttonUrl="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 设置行业接口
     */
    private static final String setIndustryUrl="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";

    /**
     * 发送模板消息
     */
    private static final String sendMessage="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    /**
     * 通过code换取网页授权access_token的url
     */
    private static final String getCodeUrl="https://api.weixin.qq.com/sns/oauth2/access_token";
    /**
     * @desc: 对普通信息进行处理
     * @author: chenyj
     * @date: 2019/7/23
     * @param is
     * @return
     */
    public static Map<String,String> parseRequest(InputStream is){
        Map<String,String> map=new HashMap<>();
        SAXReader saxReader=new SAXReader();
        try {
            Document document=saxReader.read(is);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element element:elements){
                map.put(element.getName(),element.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @description: 统一回复用户文本消息
     * @author: chenyj 2019/7/24
     * @param map
     * @return
     */
    public static String replyText(Map<String,String> map, String data){
        String result=
                "<xml>\n" +
                "<ToUserName><![CDATA["+map.get("FromUserName")+"]]></ToUserName>\n" +
                "<FromUserName><![CDATA["+map.get("ToUserName")+"]]></FromUserName>\n" +
                "<CreateTime>"+System.currentTimeMillis()/1000 +"</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA["+data+"]]></Content>\n" +
                "</xml>";
        return result;
    }


    /**
     * @description: 自定义修改菜单
     * @author: chenyj 2019/7/24
     * @return
     */
    public static String customButton(String param){
        String result=HttpRequestUtil.sendPost( buttonUrl.replace("ACCESS_TOKEN",WcChatTokenUtils.getAccessToken()),param, WcChatTokenUtils.charset);
        JSONObject jsonObject=new JSONObject(result);
        if (null!=jsonObject&&jsonObject.get("errcode").equals(0)){
            return "修改成功";
        }else {
            return jsonObject.getString("errmsg");
        }
    }

    /**
     * @description: 设置模板行业
     * @author: chenyj 2019/7/24
     * @param param
     * @return
     */
    public static String setIndustry(String param){
        String result=HttpRequestUtil.sendPost( setIndustryUrl.replace("ACCESS_TOKEN",WcChatTokenUtils.getAccessToken()),param, WcChatTokenUtils.charset);
        JSONObject jsonObject=new JSONObject(result);
        if (null!=jsonObject&&jsonObject.get("errcode").equals(0)){
            return "设置成功";
        }else {
            return jsonObject.getString("errmsg");
        }
    }

    /**
     * @description: 发送模板消息
     * @author: chenyj 2019/7/24
     * @param param
     * @return
     */
    public static String sendMessage(String param){
        String result=HttpRequestUtil.sendPost(sendMessage.replace("ACCESS_TOKEN",WcChatTokenUtils.getAccessToken()), param ,WcChatTokenUtils.charset);
        JSONObject jsonObject=new JSONObject(result);
        if (null!=jsonObject&&jsonObject.get("errcode").equals(0)){
            return "发送成功";
        }else {
            return jsonObject.getString("errmsg");
        }
    }

    /**
     * @desc: 网页授权获取用户 openid
     * @author: chenyj
     * @date: 2019/7/25
     * @param code
     */
    public static String getAccessToken(String code) {
        try {
            Map<String, Object> map=new HashMap<>();
            map.put("appid",WcChatTokenUtils.appid);
            map.put("secret",WcChatTokenUtils.appsecret);
            map.put("code",code);
            map.put("grant_type","authorization_code");
            String result=HttpRequestUtil.sendGet(getCodeUrl,map,WcChatTokenUtils.charset);
            JSONObject jsonObject=new JSONObject(result);
            String openid=jsonObject.getString("openid");
            if (openid.isEmpty()){
                return result;
            }else {
                return openid;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
