package com.jy.entity;


import com.jy.entity.SysUser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SysUserDetails implements UserDetails {
    private SysUser sysUser;
    private List<UserMenu> MenuList;

    public SysUserDetails(SysUser sysUser, List<UserMenu> menuList) {
        this.sysUser = sysUser;
        MenuList = menuList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return MenuList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .collect(Collectors.toList());
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public List getMenuList() {
        return MenuList;
    }

    public void setMenuList(List menuList) {
        MenuList = menuList;
    }


    @Override
    public String getPassword() {
        return sysUser.getUserPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUserName();
    }

    //账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //账号是否锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //凭证是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //账号启用状态
    @Override
    public boolean isEnabled() {
        return true;
    }
}
