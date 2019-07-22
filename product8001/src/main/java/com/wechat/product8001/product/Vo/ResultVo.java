package com.wechat.product8001.product.Vo;

import lombok.Data;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/22 23:26
 * 陈银杰专属测试
 */
@Data
public class ResultVo<T> {

    private Integer code;

    private String message;

    private T data;


}
