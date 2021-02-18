package com.jy.service.impl;


import com.jy.dao.ProductCategoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.entity.ProductCategory;
import com.jy.service.ProductCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品种类表 服务实现类
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

}
