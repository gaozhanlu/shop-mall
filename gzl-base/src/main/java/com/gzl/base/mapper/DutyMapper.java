package com.gzl.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.base.entity.Duty;
import com.gzl.common.model.base.duty.CheckDutyRequest;
import com.gzl.common.model.base.duty.CheckDutyResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@Mapper
public interface DutyMapper extends BaseMapper<Duty> {

    List<CheckDutyResponse> selectAllDuty(CheckDutyRequest checkDutyRequest);
}
