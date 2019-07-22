package com.wechat.product8001.product.enums;

import lombok.Getter;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/22 23:20
 * 陈银杰专属测试
 */
@Getter
public enum CategoryType {
    up(1,"在售"),
    down(2,"下线");
    private Integer code;
    private String type;

    private CategoryType(Integer code, String type) {
        this.code = code;
        this.type = type;
    }
}
