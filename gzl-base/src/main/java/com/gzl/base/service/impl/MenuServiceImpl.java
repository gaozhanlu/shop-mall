package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.gzl.base.common.model.base.menu.MenuRequest;
import com.gzl.base.common.model.base.menu.MenuResponse;
import com.gzl.base.common.util.EntityCopyUtil;
import com.gzl.base.entity.Menu;
import com.gzl.base.mapper.MenuMapper;
import com.gzl.base.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public MenuResponse saveMenu(Menu menu) {
        menuMapper.insert(menu);
        return EntityCopyUtil.toObject(menu,MenuResponse.class);
    }

    @Override
    public List<MenuResponse> selectMenu(MenuRequest menuRequest) {
        return menuMapper.selectMenu(menuRequest);
    }
}
