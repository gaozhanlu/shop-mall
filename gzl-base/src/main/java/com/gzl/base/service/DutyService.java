package com.gzl.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.base.entity.Duty;
import com.gzl.common.model.base.duty.CheckDutyRequest;
import com.gzl.common.model.base.duty.CheckDutyResponse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
public interface DutyService extends IService<Duty> {

    void insertDuty(Duty duty);

    void updateDuty(Duty duty);

    List<CheckDutyResponse> selectAllDuty(CheckDutyRequest checkDutyRequest);
}
