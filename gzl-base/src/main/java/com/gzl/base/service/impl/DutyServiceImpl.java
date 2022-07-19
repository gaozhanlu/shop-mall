package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.entity.Duty;
import com.gzl.base.mapper.DutyMapper;
import com.gzl.base.service.DutyService;
import com.gzl.common.model.base.duty.CheckDutyRequest;
import com.gzl.common.model.base.duty.CheckDutyResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@Service
public class DutyServiceImpl extends ServiceImpl<DutyMapper, Duty> implements DutyService {

    @Resource
    private DutyMapper dutyMapper;

    @Override
    public void insertDuty(Duty duty) {
        dutyMapper.insert(duty);
    }

    @Override
    public void updateDuty(Duty duty) {


    }

    @Override
    public List<CheckDutyResponse> selectAllDuty(CheckDutyRequest checkDutyRequest) {
        return dutyMapper.selectAllDuty(checkDutyRequest);
    }
}
