package com.wechat.product8001.chat.bean;

import lombok.Data;

/**
* @（#）:ViewButton.java 
* @description: 
* @author: chenyj 2019/7/24 
* @version: Version No.1
* @Copyright: 卓繁版权所有
 */
@Data
public class ViewButton extends AbstractButton {

    private String type="view";

    private String url;

    public ViewButton(String name,String url) {
        super(name);
        this.url=url;
    }
}
