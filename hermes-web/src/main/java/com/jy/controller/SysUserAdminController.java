package com.jy.controller;


import com.jy.entity.SysUser;
import com.jy.model.Result;
import com.jy.model.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 后台用户管理Controller
 * Created by macro on 2021/2817.
 */
@RestController
@Api(tags = "登陆注册")
@Slf4j
@RequestMapping("/UserAdmin")
public class SysUserAdminController {
    @ApiOperation(value = "新增")
    @GetMapping("/login")
    public Result login() {

        return new Result(StatusCode.SUCCESS, "登陆成功");
    }
}
