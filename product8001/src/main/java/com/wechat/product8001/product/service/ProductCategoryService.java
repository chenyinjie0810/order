package com.wechat.product8001.product.service;

import com.wechat.product8001.product.entity.ProductCategory;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/29 22:16
 * 陈银杰专属测试
 */
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
