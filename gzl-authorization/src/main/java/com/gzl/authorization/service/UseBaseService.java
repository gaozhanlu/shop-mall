package com.gzl.authorization.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.authorization.entity.UseBase;
import com.gzl.base.common.model.oauth.UserDetails;
import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.base.common.model.user.UseBaseResponse;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-03-02
 */

public interface UseBaseService extends IService<UseBase> {

    UseBaseResponse selectUseInfo(UseBaseRequest useBaseRequest);

    void login(UserDetails userDetails);
}
