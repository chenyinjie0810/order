package com.wechat.product8001.product.controller;

import com.wechat.product8001.product.Vo.ProductInfoVO;
import com.wechat.product8001.product.Vo.ProductVO;
import com.wechat.product8001.product.Vo.ResultVo;
import com.wechat.product8001.product.entity.ProductCategory;
import com.wechat.product8001.product.entity.ProductInfo;
import com.wechat.product8001.product.enums.CategoryType;
import com.wechat.product8001.product.service.ProductCategoryService;
import com.wechat.product8001.product.service.ProductService;
import com.wechat.product8001.product.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/22 23:22
 * 陈银杰专属测试
 */
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductInfoController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;
    
    
    @GetMapping(value = "/list")
    public ResultVo list(){
        List<ProductInfo> list=productService.findByCategoryType(CategoryType.up.getCode());
        List<Integer> collect = list.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(collect);

        List<ProductVO> productVOList=new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo:list){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultUtil.success(productVOList);
    }

}
