package com.jy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * 用户信息表
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "用户信息表")
public class SysUser extends BaseModel {

    private static final long serialVersionUID = 1L;

    //用户id
    @ApiModelProperty(value = "用户id")
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private String userId;

    //用户名称
    @ApiModelProperty(value = "用户名称")
    @TableField("USER_NAME")
    private String userName;

    //用户等级
    @ApiModelProperty(value = "用户等级")
    @TableField("USER_LEAVEL")
    private String userLeavel;

    //用户密码
    @ApiModelProperty(value = "用户密码")
    @TableField("USER_PASSWORD")
    private String userPassword;

    //用户头像
    @ApiModelProperty(value = "用户头像")
    @TableField("USER_ICON")
    private String userIcon;

    //用户昵称
    @ApiModelProperty(value = "用户昵称")
    @TableField("USER_NICK_NAME")
    private String userNickName;

    //用户邮箱
    @ApiModelProperty(value = "用户邮箱")
    @TableField("USER_EMAIL")
    private String userEmail;

    //用户备注
    @ApiModelProperty(value = "用户备注")
    @TableField("USER_NOTE")
    private String userNote;

    //创建时间
    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    //创建人
    @ApiModelProperty(value = "创建人")
    @TableField(value = "CREATE_NAME", fill = FieldFill.INSERT)
    private String createName;

    //修改时间
    @ApiModelProperty(value = "修改时间")
    @TableField(value = "MODIFY_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    //修改人
    @ApiModelProperty(value = "修改人")
    @TableField("MODIFY_NAME")
    private String modifyName;

    //版本号
    @ApiModelProperty(value = "版本号")
    @TableField("VERSION")
    private String version;


}