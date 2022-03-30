package com.gzl.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.authorization.entity.UseBase;
import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;

import org.apache.ibatis.annotations.Mapper;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-03-02
 */
@Mapper
public interface UseBaseMapper extends BaseMapper<UseBase> {

    UseBaseResponse selectUseInfo(UseBaseRequest useBaseRequest);
}
