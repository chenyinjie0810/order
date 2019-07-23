package com.wechat.product8001.chat.controller;

import com.sun.org.apache.xerces.internal.xs.XSTerm;
import com.thoughtworks.xstream.XStream;
import com.wechat.product8001.chat.bean.CheckSignature;
import com.wechat.product8001.chat.util.CheckUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
public class wehcatController {


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
     * 接受用户发送消息
     * @return
     */
    @PostMapping("get")
    public String post(HttpServletRequest request){
        log.info("接受用户消息");
        try {
            Map<String,String> map=CheckUtils.parseRequest(request.getInputStream());
            XStream xStream=new XStream();
            String s = xStream.toXML(map);
            log.info(s);
            String result="<xml>\n" +
                    "<ToUserName><![CDATA["+map.get("FromUserName")+"]]></ToUserName>\n" +
                    "<FromUserName><![CDATA["+map.get("ToUserName")+"]]></FromUserName>\n" +
                    "<CreateTime>"+System.currentTimeMillis()/1000 +"</CreateTime>\n" +
                    "<MsgType><![CDATA[text]]></MsgType>\n" +
                    "<Content><![CDATA[林深时见鹿，梦醒时见你]]></Content>\n" +
                    "</xml>";
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
