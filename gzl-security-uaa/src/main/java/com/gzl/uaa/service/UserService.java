package com.gzl.uaa.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.common.result.ViewResult;
import com.gzl.uaa.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-05-27
 */
public interface UserService extends IService<User> {

    ViewResult login(User user);

    ViewResult logout();
}
