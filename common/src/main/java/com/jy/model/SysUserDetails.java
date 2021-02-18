package com.jy.model;


import com.jy.entity.SysUser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class SysUserDetails implements UserDetails {
    private SysUser sysUser;
    private List MenuList;

    public SysUserDetails(SysUser sysUser, List menuList) {
        this.sysUser = sysUser;
        MenuList = menuList;
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
    public Collection<? extends GrantedAuthority> getAuthorities() {//返回当前用户的角色
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
