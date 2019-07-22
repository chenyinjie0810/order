package com.wechat.product8001.product.controller;

import com.wechat.product8001.product.entity.ProductInfo;
import com.wechat.product8001.product.enums.CategoryType;
import com.wechat.product8001.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/22 23:22
 * 陈银杰专属测试
 */
@RestController
public class ProductInfoController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product")
    public String get(){
        List<ProductInfo> list=productService.findByCategoryType(CategoryType.up.getCode());
        List<Integer> collect = list.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        return list.toString();
    }
}
