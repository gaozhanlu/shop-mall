package com.gzl.uaa.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;
import com.gzl.uaa.entity.UseBase;


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
