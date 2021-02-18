package com.jy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.dao.ProProductMapper;
import com.jy.entity.ProProduct;
import com.jy.service.ProProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息表 服务实现类
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */
@Service
public class ProProductServiceImpl extends ServiceImpl<ProProductMapper, ProProduct> implements ProProductService {

}
