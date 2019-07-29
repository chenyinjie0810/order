package com.wechat.product8001.product.util;

import com.wechat.product8001.product.Vo.ResultVo;

/**
 * @Author chenyj
 * @Description
 * @Date create by 2019/7/29 23:07
 * 陈银杰专属测试
 */
public class ResultUtil {

    /**
     * @desc:
     * @author: chenyj
     * @date: 2019/7/29
     * @param o
     * @return
     */
    public static ResultVo success(Object o){
        ResultVo resultVo=new ResultVo();
        resultVo.setData(o);
        resultVo.setCode(0);
        resultVo.setMessage("成功");
        return  resultVo;
    }
}
