package com.jy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.jy.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品种类表
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("product_category")
@ApiModel(value = "ProductCategory对象", description = "商品种类表")
public class ProductCategory extends BaseModel {

    private static final long serialVersionUID = 1L;

    //父级分类的id
    @ApiModelProperty(value = "父级分类的id")
    @TableId(value = "PARENT_ID", type = IdType.AUTO)
    private Integer parentId;

    //商品分类名称
    @ApiModelProperty(value = "商品分类名称")
    @TableField("PARENT_NAME")
    private String parentName;

    //分类单位
    @ApiModelProperty(value = "分类单位")
    @TableField("CATEGORY_UNIT")
    private String categoryUnit;

    //是否进行显示
    @ApiModelProperty(value = "是否进行显示")
    @TableField("CATEGORY_SHOW_STATUS")
    private String categoryShowStatus;

    //排序
    @ApiModelProperty(value = "排序")
    @TableField("CATEGORY_SORT")
    private String categorySort;

    //图标
    @ApiModelProperty(value = "图标")
    @TableField("CATEGORY_ICON")
    private String categoryIcon;

    //描述
    @ApiModelProperty(value = "描述")
    @TableField("CATEGORY_DESCRIPTION")
    private String categoryDescription;

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