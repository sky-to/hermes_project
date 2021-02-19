package com.jy.controller;


import com.jy.model.PageResult;
import com.jy.model.Result;
import com.jy.model.StatusCode;
import com.jy.service.UserMenuService;
import com.jy.entity.UserMenu;
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
    * 后台菜单表 前端控制器
    * </p>
*
* @author jiaoyun
* @since 2021-02-19
*/

@Slf4j
@Api(tags = "后台菜单表")
    @RestController
@RequestMapping("/userMenu")
        public class UserMenuController {

        @Autowired
        public UserMenuService userMenuService;

        @ApiOperation(value = "新增")
        @PostMapping("/save")
        public Result save(@RequestBody UserMenu userMenu){
        userMenuService.save(userMenu);
        return new Result(StatusCode.SUCCESS,"保存成功");
        }

        @ApiOperation(value = "根据id删除")
        @DeleteMapping("/delete/{id}")
        public Result delete(@PathVariable("id") Long id){
        userMenuService.removeById(id);
        return new Result(StatusCode.SUCCESS,"删除成功");
        }

        @ApiOperation(value = "条件查询")
        @GetMapping("/get")
        public Result list(@RequestBody UserMenu userMenu){
        List<UserMenu> userMenuList = userMenuService.list(new QueryWrapper<>(userMenu));
        return new Result(StatusCode.SUCCESS,"查询成功",userMenuList);
        }

        @ApiOperation(value = "列表（分页）")
        @GetMapping("/list/{pageNum}/{pageSize}")
        public Object list(@PathVariable("pageNum")Long pageNum, @PathVariable("pageSize")Long pageSize){
        IPage<UserMenu> page = userMenuService.page(
        new Page<>(pageNum, pageSize), null);
        return new Result(StatusCode.SUCCESS,"查询成功",new PageResult<>(page.getTotal(),page.getRecords()));
        }

        @ApiOperation(value = "详情")
        @GetMapping("/get/{id}")
        public Result get(@PathVariable("id") String id){
        UserMenu userMenu = userMenuService.getById(id);
        return new Result(StatusCode.SUCCESS,"查询成功",userMenu);
        }

        @ApiOperation(value = "根据id修改")
        @PutMapping("/update/{id}")
        public Result update(@PathVariable("id") String id, @RequestBody UserMenu userMenu){
        userMenu.setId(id);
        userMenuService.updateById(userMenu);
        return new Result(StatusCode.SUCCESS,"更新成功");
        }


    }
