package com.jy.controller;


import com.jy.model.PageResult;
import com.jy.model.Result;
import com.jy.model.StatusCode;
import com.jy.service.UserPermissionService;
import com.jy.entity.UserPermission;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 后台用户权限表 前端控制器
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-19
 */

@Slf4j
@Api(tags = "后台用户权限表")
@RestController
@RequestMapping("/lujing/userPermission")
public class UserPermissionController {

    @Autowired
    public UserPermissionService userPermissionService;

    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody UserPermission userPermission) {
        userPermissionService.save(userPermission);
        return new Result(StatusCode.SUCCESS, "保存成功");
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        userPermissionService.removeById(id);
        return new Result(StatusCode.SUCCESS, "删除成功");
    }

    @ApiOperation(value = "条件查询")
    @GetMapping("/get")
    public Result list(@RequestBody UserPermission userPermission) {
        List<UserPermission> userPermissionList = userPermissionService.list(new QueryWrapper<>(userPermission));
        return new Result(StatusCode.SUCCESS, "查询成功", userPermissionList);
    }

    @ApiOperation(value = "列表（分页）")
    @GetMapping("/list/{pageNum}/{pageSize}")
    public Object list(@PathVariable("pageNum") Long pageNum, @PathVariable("pageSize") Long pageSize) {
        IPage<UserPermission> page = userPermissionService.page(
                new Page<>(pageNum, pageSize), null);
        return new Result(StatusCode.SUCCESS, "查询成功", new PageResult<>(page.getTotal(), page.getRecords()));
    }

    @ApiOperation(value = "详情")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") String id) {
        UserPermission userPermission = userPermissionService.getById(id);
        return new Result(StatusCode.SUCCESS, "查询成功", userPermission);
    }

    @ApiOperation(value = "根据id修改")
    @PutMapping("/update/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody UserPermission userPermission) {
        userPermission.setId(id);
        userPermissionService.updateById(userPermission);
        return new Result(StatusCode.SUCCESS, "更新成功");
    }


}
