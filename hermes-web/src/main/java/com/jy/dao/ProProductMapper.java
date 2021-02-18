package com.jy.dao;

import com.jy.entity.ProProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* <p>
    * 商品信息表 Mapper 接口
    * </p>
*
* @author jiaoyun
* @since 2021-02-17
*/
    @Mapper
    public interface ProProductMapper extends BaseMapper<ProProduct> {

    }
