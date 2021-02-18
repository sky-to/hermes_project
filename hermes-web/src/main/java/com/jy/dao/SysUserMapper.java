package com.jy.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
* <p>
    * 用户信息表 Mapper 接口
    * </p>
*
* @author jiaoyun
* @since 2021-02-17
*/
    @Mapper
    public interface SysUserMapper extends BaseMapper<SysUser> {

    }
