package com.gzl.uaa.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.base.common.util.EntityCopyUtil;
import com.gzl.uaa.entity.UseBase;
import com.gzl.uaa.mapper.UseBaseMapper;
import com.gzl.uaa.service.UseBaseService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public List<UseBaseResponse>  selectUseInfo(UseBaseRequest useBaseRequest) {

        return useBaseMapper.selectUseInfo(useBaseRequest);
    }




    @Override
    public void insertUseInfo(UseBaseRequest useBaseRequest) {
        UseBase useBase=EntityCopyUtil.toObject(useBaseRequest,UseBase.class);
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        useBase.setPassWord(bCryptPasswordEncoder.encode(useBase.getPassWord()));
        useBaseMapper.insert(useBase);

    }

}
