package com.wechat.product8001.product.service.impl;

import com.netflix.discovery.converters.Auto;
import com.wechat.product8001.product.entity.ProductCategory;
import com.wechat.product8001.product.repository.ProductCategoryRepository;
import com.wechat.product8001.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/29 22:17
 * 陈银杰专属测试
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return productCategoryRepository.findByCategoryTypeIn(categoryType);
    }
}
