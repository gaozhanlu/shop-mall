package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.entity.Organization;
import com.gzl.base.mapper.OrganizationMapper;
import com.gzl.base.service.OrganizationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组织关系表 可配置 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-07-19
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

}
