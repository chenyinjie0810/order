package com.wechat.product8001.chat.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
* @（#）:Subbutton.java 
* @description: 
* @author: chenyj 2019/7/24 
* @version: Version No.1
* @Copyright: 卓繁版权所有
 */
@Data
public class Subbutton extends AbstractButton {

    private List<AbstractButton> sub_button=new ArrayList<>();

    public Subbutton(String name) {
        super(name);
    }
}
