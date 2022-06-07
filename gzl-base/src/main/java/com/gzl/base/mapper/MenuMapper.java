package com.gzl.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.common.model.base.menu.MenuRequest;
import com.gzl.common.model.base.menu.MenuResponse;
import com.gzl.base.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-05-29
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuResponse> selectMenu(MenuRequest menuRequest);
}
