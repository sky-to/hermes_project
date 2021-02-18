package com.jy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.entity.ProProduct;
import com.jy.model.PageResult;
import com.jy.model.Result;
import com.jy.model.StatusCode;
import com.jy.service.ProProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品信息表 前端控制器
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */

@Slf4j
@Api(tags = "商品信息表")
@RestController
@RequestMapping("/proProduct")
public class ProProductController {

    @Autowired
    public ProProductService proProductService;

    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody ProProduct proProduct) {
        proProductService.save(proProduct);
        return new Result(StatusCode.SUCCESS, "保存成功");
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        proProductService.removeById(id);
        return new Result(StatusCode.SUCCESS, "删除成功");
    }

    @ApiOperation(value = "条件查询")
    @PostMapping("/get")
    public Result list(@RequestBody ProProduct proProduct) {
        List<ProProduct> proProductList = proProductService.list(new QueryWrapper<>(proProduct));
        return new Result(StatusCode.SUCCESS, "查询成功", proProductList);
    }

    @ApiOperation(value = "列表（分页）")
    @GetMapping("/list/{pageNum}/{pageSize}")
    public Object list(@PathVariable("pageNum") Long pageNum, @PathVariable("pageSize") Long pageSize) {
        IPage<ProProduct> page = proProductService.page(
                new Page<>(pageNum, pageSize), null);
        return new Result(StatusCode.SUCCESS, "查询成功", new PageResult<>(page.getTotal(), page.getRecords()));
    }

    @ApiOperation(value = "详情")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") String id) {
        ProProduct proProduct = proProductService.getById(id);
        return new Result(StatusCode.SUCCESS, "查询成功", proProduct);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody ProProduct proProduct) {
        proProduct.setProductId(id);
        proProductService.updateById(proProduct);
        return new Result(StatusCode.SUCCESS, "更新成功");
    }


}
