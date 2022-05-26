package com.gzl.user.service.impl;


import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.user.entity.UseBase;
import com.gzl.user.mapper.UseBaseMapper;
import com.gzl.user.service.UseBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-03-02
 */
@Service
public class UseBaseServiceImpl extends ServiceImpl<UseBaseMapper, UseBase> implements UseBaseService {


    @Resource
    private UseBaseMapper useBaseMapper;
    @Override
    @Cacheable(value = {"CtrlMenuDetail"},key = "#root.method.name+'_'+#useBaseRequest")
    public List<UseBaseResponse> selectUseInfo(UseBaseRequest useBaseRequest) {

        return useBaseMapper.selectUseInfo(useBaseRequest);
    }

}
