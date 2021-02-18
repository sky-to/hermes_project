package com.jy.controller;


import com.jy.entity.SysUser;
import com.jy.model.Result;
import com.jy.model.StatusCode;
import com.jy.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台用户管理Controller
 * Created by macro on 2021/2817.
 */
@RestController
@Api(tags = "登陆注册")
@Slf4j
@RequestMapping("/UserAdmin")
public class SysUserAdminController {
    @Resource
    private SysUserService userService;

    @ApiOperation(value = "登录以后返回token")
    @PostMapping("/login")
    public Result login(@RequestBody @Validated SysUser sysUser) {
      SysUser user  =userService.login(sysUser.getUserName(), sysUser.getUserPassword());
      if (user==null){
          return new Result(StatusCode.ERROR,"用户不存在");
      }
        return new Result(StatusCode.SUCCESS, "登陆成功");
    }
}
