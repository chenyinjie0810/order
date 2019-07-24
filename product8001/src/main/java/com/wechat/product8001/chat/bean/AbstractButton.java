package com.wechat.product8001.chat.bean;

import lombok.Data;
import lombok.ToString;

/**
* @（#）:WeCahtSonButton.java 
* @description: 
* @author: chenyj 2019/7/24 
* @version: Version No.1
* @Copyright: 卓繁版权所有
 */
@Data
@ToString
public abstract class AbstractButton {
    private String name;

    public AbstractButton(String name) {
        this.name = name;
    }
}
