package com.jy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.dao.SysUserMapper;
import com.jy.dao.UserMenuMapper;
import com.jy.entity.SysUser;
import com.jy.entity.UserMenu;
import com.jy.exception.SysUserException;
import com.jy.entity.SysUserDetails;

import com.jy.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private UserMenuMapper userMenuMapper;

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
            List<UserMenu> menuList = getMenuList(user.getUserId());
            return new SysUserDetails(user, menuList);
        }
        throw new SysUserException("用户名或密码错误");
    }

    private List getMenuList(String userId) {//通过用户id去中间表查询他所拥有的菜单id，中间表还没建，todo
        UserMenu userMenu = userMenuMapper.selectById(userId);
        return null;
    }

    private SysUser getAdminByUserName(String userName) {//正常来说这里要去缓存拿的，等弄到那儿再改吧
         SysUser sysUser =sysUserMapper.selectByUserName(userName);
        return sysUser;
    }
}
