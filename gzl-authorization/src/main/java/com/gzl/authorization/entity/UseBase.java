package com.gzl.authorization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author gzl
 * @since 2022-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UseBase对象", description = "")
public class UseBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String accountId;

    private String accountName;

    private String passWord;


}
