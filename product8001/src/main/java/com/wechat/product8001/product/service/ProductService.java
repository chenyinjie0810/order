package com.wechat.product8001.product.service;

import com.wechat.product8001.product.entity.ProductInfo;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/22 23:01
 * 陈银杰专属测试
 */
public interface ProductService {

    List<ProductInfo> findByCategoryType(Integer type);
}
