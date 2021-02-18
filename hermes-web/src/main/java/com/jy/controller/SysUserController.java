package com.jy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.entity.SysUser;
import com.jy.model.PageResult;
import com.jy.model.Result;
import com.jy.model.StatusCode;
import com.jy.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */

@Slf4j
@Api(tags = "用户信息表")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    public SysUserService sysUserService;


    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
        return new Result(StatusCode.SUCCESS, "保存成功");
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        sysUserService.removeById(id);
        return new Result(StatusCode.SUCCESS, "删除成功");
    }

    @ApiOperation(value = "条件查询")
    @PostMapping("/get")
    public Result list(@RequestBody SysUser sysUser) {
        List<SysUser> sysUserList = sysUserService.list(new QueryWrapper<>(sysUser));
        return new Result(StatusCode.SUCCESS, "查询成功", sysUserList);
    }

    @ApiOperation(value = "列表（分页）")
    @GetMapping("/list/{pageNum}/{pageSize}")
    public Object list(@PathVariable("pageNum") Long pageNum, @PathVariable("pageSize") Long pageSize) {
        IPage<SysUser> page = sysUserService.page(
                new Page<>(pageNum, pageSize), null);
        return new Result(StatusCode.SUCCESS, "查询成功", new PageResult<>(page.getTotal(), page.getRecords()));
    }

    @ApiOperation(value = "详情")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") String id) {
        SysUser sysUser = sysUserService.getById(id);
        return new Result(StatusCode.SUCCESS, "查询成功", sysUser);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody SysUser sysUser) {
        sysUser.setUserId(id);
        sysUserService.updateById(sysUser);
        return new Result(StatusCode.SUCCESS, "更新成功");
    }


}
