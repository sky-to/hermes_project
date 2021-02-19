package com.jy.dao;

import com.jy.entity.UserPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* <p>
    * 后台用户权限表 Mapper 接口
    * </p>
*
* @author jiaoyun
* @since 2021-02-19
*/
    @Mapper
    public interface UserPermissionMapper extends BaseMapper<UserPermission> {

    }
