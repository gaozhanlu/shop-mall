package com.gzl.authorization.service.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.gzl.authorization.entity.UseBase;
import com.gzl.authorization.mapper.UseBaseMapper;
import com.gzl.authorization.service.UseBaseService;
import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.base.common.util.EntityCopyUtil;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public UseBaseResponse selectUseInfo(UseBaseRequest useBaseRequest) {

        return useBaseMapper.selectUseInfo(useBaseRequest);
    }

    @Override
    public void login(UserDetails userDetails) {
        //根据用户的id查询用户的权限
        UseBaseRequest useBaseRequest= EntityCopyUtil.toObject(userDetails,UseBaseRequest.class);
        UseBaseResponse useBaseResponse=useBaseMapper.selectUseInfo(useBaseRequest);

        String principal = JSON.toJSONString(useBaseResponse);

    }

}
