package com.chenyj.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/30 21:53
 * 陈银杰专属测试
 */
@AllArgsConstructor
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    END(1,"已完结"),
    CANCEL(2,"取消");

    private Integer code;

    private String message;

}
