package com.jy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.dao.SysUserMapper;
import com.jy.dao.UserMenuMapper;
import com.jy.entity.SysUser;
import com.jy.entity.UserMenu;
import com.jy.exception.SysUserException;
import com.jy.entity.SysUserDetails;

import com.jy.service.SysUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private PasswordEncoder passwordEncoder;



    @Override
    public String login(String userName, String userPassword) {
        String token = null;
        SysUserDetails user = loadUserByUserName(userName);
        if (passwordEncoder.matches(userPassword,user.getPassword())){
            throw new SysUserException("密码不正确");
        }
        if (!user.isEnabled()){
            throw new SysUserException("账号被禁用");
        }
        //security里的东西，看了一下源码，应该是给当前的用户，凭证，用户Detail里的角色
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        Claims claims = Jwts.parser().setSigningKey(user.getPassword()).parseClaimsJws("").getBody();
        token= Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256,user.getPassword())
                .compact();
        return token;
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

    private List<UserMenu> getMenuList(String userId) {//通过用户id去中间表查询他所拥有的菜单id，中间表还没建，todo
        List<UserMenu> userMenuList= userMenuMapper.getMenuListByUserId(userId);
        return userMenuList;
    }

    private SysUser getAdminByUserName(String userName) {//正常来说这里要去缓存拿的，等弄到那儿再改吧
         SysUser sysUser =sysUserMapper.selectByUserName(userName);
        return sysUser;
    }
}
