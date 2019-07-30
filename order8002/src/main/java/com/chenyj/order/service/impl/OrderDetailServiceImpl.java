package com.chenyj.order.service.impl;

import com.chenyj.order.entity.OrderDetail;
import com.chenyj.order.repository.OrderDetailRepository;
import com.chenyj.order.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/30 22:00
 * 陈银杰专属测试
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public void get(){
        OrderDetail orderDetail=orderDetailRepository.save(new OrderDetail());
    }
}
