package com.wechat.product8001.chat.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
* @（#）:PhotoOrAlbumButton.java 
* @description: 
* @author: chenyj 2019/7/24 
* @version: Version No.1
* @Copyright: 卓繁版权所有
 */
@Data
public class PhotoOrAlbumButton extends AbstractButton {

    private String type="pic_photo_or_album";

    private String key;

    private List<AbstractButton> sub_button=new ArrayList<>();

    public PhotoOrAlbumButton(String name,String key) {
        super(name);
        this.key=key;
    }
}
