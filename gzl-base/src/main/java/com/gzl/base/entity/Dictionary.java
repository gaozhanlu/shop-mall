package com.gzl.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gzl
 * @since 2022-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dictionary")
@ApiModel(value="Dictionary", description="")
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "key值")
    private String funcKey;

    @ApiModelProperty(value = "父节点key")
    private String parentKey;

    @ApiModelProperty(value = "英文名")
    private String enName;

    @ApiModelProperty(value = "中文名")
    private String cnName;

    @ApiModelProperty(value = "value值")
    private String funcValue;

    @ApiModelProperty(value = "描述")
    private String funcDescribe;

    @ApiModelProperty(value = "类型")
    private String funcType;

    @ApiModelProperty(value = "描述")
    private String remark;


}
