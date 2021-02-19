package com.jy.dao;

import com.jy.entity.UserMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* <p>
    * 后台菜单表 Mapper 接口
    * </p>
*
* @author jiaoyun
* @since 2021-02-19
*/
    @Mapper
    public interface UserMenuMapper extends BaseMapper<UserMenu> {

    }
