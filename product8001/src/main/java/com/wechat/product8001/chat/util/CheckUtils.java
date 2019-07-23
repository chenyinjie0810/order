package com.wechat.product8001.chat.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/23 22:02
 * 陈银杰专属测试
 */
public class CheckUtils {

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
}
