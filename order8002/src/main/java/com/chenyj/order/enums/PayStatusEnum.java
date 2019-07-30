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
public enum PayStatusEnum {
    SUCCESS(0,"支付完成"),
    FAIL(1,"支付失败"),
    WAIT(2,"等待支付");

    private Integer code;

    private String message;

}
