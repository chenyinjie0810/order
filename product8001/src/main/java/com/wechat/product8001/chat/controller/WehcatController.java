package com.wechat.product8001.chat.controller;

import com.wechat.product8001.chat.bean.*;
import com.wechat.product8001.chat.util.WcChatTokenUtils;
import com.wechat.product8001.chat.util.WeChatUtils;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/23 20:21
 * 陈银杰专属测试
 */
@RestController
@RequestMapping("/weChat/")
@Slf4j
public class WehcatController {


    /**
     * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * timestamp	时间戳
     * nonce	随机数
     * echostr	随机字符串
     * @return
     */
    @GetMapping("get")
    public String get(CheckSignature checkSignature){
        log.info("验证链接是否通过");
        if (checkSignature.check()){
            return checkSignature.getEchostr();
        }else {
            return null;
        }
    }

    /**
     * @description: 接受用户发送消息
     * @author: chenyj 2019/7/24
     * @return
     */
    @PostMapping("get")
    public String post(HttpServletRequest request){
        log.info("接受用户消息");
        try {
            Map<String,String> map= WeChatUtils.parseRequest(request.getInputStream());
            String content=map.get("Content");
            StringBuffer replContent=new StringBuffer();
            switch (content){
                case "登录":
                    String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WcChatTokenUtils.appid+"&redirect_uri="+URLEncoder.encode("http://5rbit2.natappfree.cc/weChat/getUserInfo","UTF-8")+"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
                    replContent.append("点击<a href=\""+url+"\">这里</a>登录");
                    break;
                case "测试":
                    replContent.append("");
                    break;
                default:
                    replContent.append("林深时见鹿，梦醒时见你");
                    break;
            }

            return WeChatUtils.replyText(map,replContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @description: 获取token测试
     * @author: chenyj 2019/7/24
     * @return
     */
    @GetMapping("getToken")
    public String getToken(){
        return WcChatTokenUtils.getAccessToken();
    }


    /**
     * @description: 修改自定义菜单
     * @author: chenyj 2019/7/24
     * @return
     */
    @GetMapping("customButton")
    public String customButton(){
        WeChatButton weChatButton=new WeChatButton();
        weChatButton.getButton().add(new ClickButton("林深时见鹿","1"));
        weChatButton.getButton().add(new ViewButton("海蓝时见鲸","https://www.baidu.com/"));
        Subbutton subbutton=new Subbutton("梦醒时见你");
        subbutton.getSub_button().add(new ClickButton("鹿踏雾而来","2"));
        subbutton.getSub_button().add(new ViewButton("鲸随浪而涌","https://weibo.com"));
        subbutton.getSub_button().add(new ClickButton("你没回头","3"));
        subbutton.getSub_button().add(new PhotoOrAlbumButton("又怎知我不在","4"));
        weChatButton.getButton().add(subbutton);
        JSONObject jsonObject=new JSONObject(weChatButton);
        return WeChatUtils.customButton(jsonObject.toString());
    }


    /**
     *
     * @description: 设置模板行业
     * @author: chenyj 2019/7/24
     * @return
     */
    @GetMapping("setIndustry")
    public String setIndustry(){
        String param="{\n" +
                "    \"industry_id1\":\"1\",\n" +
                "    \"industry_id2\":\"4\"\n" +
                "}";
       return WeChatUtils.setIndustry(param);
    }

    /**
     * 发送消息
     * @return
     */
    @GetMapping("sendMessage")
    public String sendMessage(){
        String param="{\n" +
                "           \"touser\":\"ok-oWwTEdq6eH6gTB-bN_9Ec8uBU\",\n" +
                "           \"template_id\":\"rTh7soXTQwpuWtlrBkyWQ8ZF3AHixydK3JaDvS4bTmc\",\n" +
                "           \"url\":\"http://weixin.qq.com/download\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"恭喜你购买成功！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"巧克力\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword2\": {\n" +
                "                       \"value\":\"39.8元\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword3\": {\n" +
                "                       \"value\":\"2014年9月22日\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"欢迎再次购买！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        return WeChatUtils.sendMessage(param);
    }

    @GetMapping("getUserInfo")
    public String get(){
        return "1111";
    }


}
