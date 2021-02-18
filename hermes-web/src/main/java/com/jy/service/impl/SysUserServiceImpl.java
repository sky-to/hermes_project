package com.jy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.dao.SysUserMapper;
import com.jy.entity.SysUser;
import com.jy.exception.SysUserException;
import com.jy.model.SysUserDetails;

import com.jy.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser login(String userName, String userPassword) {
        String token = null;
        SysUserDetails user = loadUserByUserName(userName);
        return null;
    }

    /*
     * 根据用户名查询到用户，再去查询到用户所拥有的权限菜单
     * */
    private SysUserDetails loadUserByUserName(String userName) {
        SysUser user = getAdminByUserName(userName);
        if (user != null) {
            List menuList = getMenuList(user.getUserId());
            return new SysUserDetails(user, menuList);
        }
        throw new SysUserException("用户名或密码错误");
    }

    private List getMenuList(String userId) {//Todo

        return null;
    }

    private SysUser getAdminByUserName(String userName) {//todo
        return null;
    }
}
