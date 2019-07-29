package com.wechat.product8001.product.controller;

import com.wechat.product8001.product.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/29 22:19
 * 陈银杰专属测试
 */
@RestController
@Slf4j
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

}
