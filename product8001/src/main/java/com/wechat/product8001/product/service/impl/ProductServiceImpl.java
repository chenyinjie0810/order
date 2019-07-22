package com.wechat.product8001.product.service.impl;

import com.wechat.product8001.product.entity.ProductInfo;
import com.wechat.product8001.product.repository.ProductRepository;
import com.wechat.product8001.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/22 23:02
 * 陈银杰专属测试
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductInfo> findByCategoryType(Integer type) {
        return productRepository.findByCategoryType(type);
    }
}
