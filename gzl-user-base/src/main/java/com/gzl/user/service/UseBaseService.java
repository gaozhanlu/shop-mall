package com.gzl.user.service;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.user.entity.UseBase;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-03-02
 */

public interface UseBaseService extends IService<UseBase> {

    List<UseBaseResponse> selectUseInfo(UseBaseRequest useBaseRequest);


    void insertUseInfo(UseBaseRequest useBaseRequest);
}
