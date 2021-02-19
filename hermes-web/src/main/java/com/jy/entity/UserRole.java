package com.jy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台用户角色表
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_role")
@ApiModel(value = "UserRole对象", description = "后台用户角色表")
public class UserRole extends BaseModel {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    //名称
    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    //描述
    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    //后台用户数量
    @ApiModelProperty(value = "后台用户数量")
    @TableField("admin_count")
    private Integer adminCount;

    //创建时间
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    //启用状态：0->禁用；1->启用
    @ApiModelProperty(value = "启用状态：0->禁用；1->启用")
    @TableField("status")
    private Integer status;

    @TableField("sort")
    private Integer sort;


}