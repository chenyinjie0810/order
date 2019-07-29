package com.wechat.product8001.product.repository;

import com.wechat.product8001.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/22 23:08
 * 陈银杰专属测试
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
