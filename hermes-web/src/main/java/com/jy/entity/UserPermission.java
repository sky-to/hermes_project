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
 * 后台用户权限表
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_permission")
@ApiModel(value = "UserPermission对象", description = "后台用户权限表")
public class UserPermission extends BaseModel {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    //父级权限id
    @ApiModelProperty(value = "父级权限id")
    @TableField("pid")
    private Long pid;

    //名称
    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    //权限值
    @ApiModelProperty(value = "权限值")
    @TableField("value")
    private String value;

    //图标
    @ApiModelProperty(value = "图标")
    @TableField("icon")
    private String icon;

    //权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
    @ApiModelProperty(value = "权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    @TableField("type")
    private Integer type;

    //前端资源路径
    @ApiModelProperty(value = "前端资源路径")
    @TableField("uri")
    private String uri;

    //启用状态；0->禁用；1->启用
    @ApiModelProperty(value = "启用状态；0->禁用；1->启用")
    @TableField("status")
    private Integer status;

    //创建时间
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    //排序
    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;


}