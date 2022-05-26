package com.gzl.user.mapper;

import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.user.entity.UseBase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


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

    List<UseBaseResponse> selectUseInfo(UseBaseRequest useBaseRequest);
}
