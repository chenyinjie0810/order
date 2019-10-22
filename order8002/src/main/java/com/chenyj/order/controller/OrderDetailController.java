package com.chenyj.order.controller;

import com.chenyj.order.entity.OrderDetail;
import com.chenyj.order.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/31 23:23
 * 陈银杰专属测试
 */
@RestController
@RequestMapping("/order")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping(value = "/")
    public String get(){
        return "我是消费者";
    }

}
