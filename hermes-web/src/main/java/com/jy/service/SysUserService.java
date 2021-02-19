package com.jy.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.entity.SysUser;


/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */

public interface SysUserService extends IService<SysUser> {

    String login(String userName, String userPassword);
}
