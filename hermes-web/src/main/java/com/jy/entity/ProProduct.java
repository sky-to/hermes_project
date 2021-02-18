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
 * 商品信息表
 * </p>
 *
 * @author jiaoyun
 * @since 2021-02-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("pro_product")
@ApiModel(value = "ProProduct对象", description = "商品信息表")
public class ProProduct extends BaseModel {

    private static final long serialVersionUID = 1L;

    //商品id
    @ApiModelProperty(value = "商品id")
    @TableId(value = "PRODUCT_ID", type = IdType.UUID)
    private String productId;

    //商品名称
    @ApiModelProperty(value = "商品名称")
    @TableField("PRODUCT_NAME")
    private String productName;

    //商品数量
    @ApiModelProperty(value = "商品数量")
    @TableField("PRODUCT_NUMBER")
    private String productNumber;

    //商品库存
    @ApiModelProperty(value = "商品库存")
    @TableField("PRODUCT_STOCK")
    private String productStock;

    //供应商名称
    @ApiModelProperty(value = "供应商名称")
    @TableField("PRODUCT_SUPLIER")
    private String productSuplier;

    //供应商id
    @ApiModelProperty(value = "供应商id")
    @TableField("PRODUCT_SUPLIER_ID")
    private String productSuplierId;

    //商品类型
    @ApiModelProperty(value = "商品类型")
    @TableField("PRODUCT_TYPE")
    private String productType;

    //商品父级类型
    @ApiModelProperty(value = "商品父级类型")
    @TableField("PRODUCT_PARTENT_TYPE")
    private String productPartentType;

    //商品编号
    @ApiModelProperty(value = "商品编号")
    @TableField("PRODUCT_CODE")
    private String productCode;

    //商品类型编号
    @ApiModelProperty(value = "商品类型编号")
    @TableField("PRODUCT_TYPE_CODE")
    private String productTypeCode;

    //商品品牌名
    @ApiModelProperty(value = "商品品牌名")
    @TableField("PRODUCT_BRAND_NAME")
    private String productBrandName;

    //商品品牌id
    @ApiModelProperty(value = "商品品牌id")
    @TableField("PRODUCT_BRAND_CODE")
    private String productBrandCode;

    //商品状态，0.下架，1.在售，2售罄
    @ApiModelProperty(value = "商品状态，0.下架，1.在售，2售罄")
    @TableField("PRODUCT_STATUS")
    private Integer productStatus;

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

    //商品描述
    @ApiModelProperty(value = "商品描述")
    @TableField("PRODUCT_DESCRIBE")
    private String productDescribe;


}