package com.wechat.product8001.chat.bean;

import lombok.Data;

/**
* @（#）:ClickButton.java 
* @description: 
* @author: chenyj 2019/7/24 
* @version: Version No.1
* @Copyright: 卓繁版权所有
 */
@Data
public class ClickButton extends AbstractButton {

    private String type="click";

    private String key;

    public ClickButton(String name,String key) {
        super(name);
        this.key=key;
    }
}
