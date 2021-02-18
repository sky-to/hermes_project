package com.jy.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.entity.ProductCategory;
import com.jy.model.PageResult;
import com.jy.model.Result;
import com.jy.model.StatusCode;
import com.jy.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品种类表 前端控制器
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */

@Slf4j
@Api(tags = "商品种类表")
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    public ProductCategoryService productCategoryService;

    @ApiOperation(value = "新增")
    @PostMapping("/save")
    public Result save(@RequestBody ProductCategory productCategory) {
        productCategoryService.save(productCategory);
        return new Result(StatusCode.SUCCESS, "保存成功");
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping ("/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        productCategoryService.removeById(id);
        return new Result(StatusCode.SUCCESS, "删除成功");
    }

    @ApiOperation(value = "条件查询")
    @GetMapping("/get")
    public Result list(@RequestBody ProductCategory productCategory) {
        List<ProductCategory> productCategoryList = productCategoryService.list(new QueryWrapper<>(productCategory));
        return new Result(StatusCode.SUCCESS, "查询成功", productCategoryList);
    }

    @ApiOperation(value = "列表（分页）")
    @GetMapping("/list/{pageNum}/{pageSize}")
    public Object list(@PathVariable("pageNum") Long pageNum, @PathVariable("pageSize") Long pageSize) {
        IPage<ProductCategory> page = productCategoryService.page(
                new Page<>(pageNum, pageSize), null);
        return new Result(StatusCode.SUCCESS, "查询成功", new PageResult<>(page.getTotal(), page.getRecords()));
    }

    @ApiOperation(value = "详情")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") String id) {
        ProductCategory productCategory = productCategoryService.getById(id);
        return new Result(StatusCode.SUCCESS, "查询成功", productCategory);
    }

    @ApiOperation(value = "根据id修改")
    @PutMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer id, @RequestBody ProductCategory productCategory) {
        productCategory.setParentId(id);
        productCategoryService.updateById(productCategory);
        return new Result(StatusCode.SUCCESS, "更新成功");
    }


}
