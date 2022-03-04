package com.gzl.user.service;


import com.gzl.base.common.model.user.UseBaseRequest;
import com.gzl.user.entity.UseBase;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-03-02
 */

public interface UseBaseService extends IService<UseBase> {

    void selectUseInfo(UseBaseRequest useBaseRequest);
}
