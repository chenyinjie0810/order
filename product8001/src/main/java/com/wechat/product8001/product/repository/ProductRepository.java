package com.wechat.product8001.product.repository;

import com.wechat.product8001.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/22 23:03
 * 陈银杰专属测试
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByCategoryType(Integer type);
}
