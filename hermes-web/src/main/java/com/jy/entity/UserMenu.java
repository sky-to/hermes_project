package com.jy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.jy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台菜单表
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_menu")
@ApiModel(value = "UserMenu对象", description = "后台菜单表")
public class UserMenu extends BaseModel {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    //父级ID
    @ApiModelProperty(value = "父级ID")
    @TableField("parent_id")
    private Long parentId;

    //创建时间
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    //菜单名称
    @ApiModelProperty(value = "菜单名称")
    @TableField("title")
    private String title;

    //菜单级数
    @ApiModelProperty(value = "菜单级数")
    @TableField("level")
    private Integer level;

    //菜单排序
    @ApiModelProperty(value = "菜单排序")
    @TableField("sort")
    private Integer sort;

    //前端名称
    @ApiModelProperty(value = "前端名称")
    @TableField("name")
    private String name;

    //前端图标
    @ApiModelProperty(value = "前端图标")
    @TableField("icon")
    private String icon;

    //前端隐藏
    @ApiModelProperty(value = "前端隐藏")
    @TableField("hidden")
    private Integer hidden;


}