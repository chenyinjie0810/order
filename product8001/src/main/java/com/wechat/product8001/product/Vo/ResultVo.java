package com.wechat.product8001.product.Vo;

import lombok.Data;
import lombok.ToString;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/22 23:26
 * 陈银杰专属测试
 */
@Data
@ToString
public class ResultVo<T> {

    private Integer code;

    private String message;

    private T data;


}
