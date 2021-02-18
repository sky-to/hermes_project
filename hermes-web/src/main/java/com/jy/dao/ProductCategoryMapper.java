package com.jy.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品种类表 Mapper 接口
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */
@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

}
