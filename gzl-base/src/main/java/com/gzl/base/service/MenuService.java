package com.gzl.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.base.common.model.base.menu.MenuRequest;
import com.gzl.base.common.model.base.menu.MenuResponse;
import com.gzl.base.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
public interface MenuService extends IService<Menu> {

    MenuResponse saveMenu(Menu menu);

    List<MenuResponse> selectMenu(MenuRequest menuRequest);
}
