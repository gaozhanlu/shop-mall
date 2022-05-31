package com.gzl.base.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzl.base.common.packagemodel.PageRequest;
import com.gzl.base.common.packagemodel.PageResult;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class PageChangeUtil {

    public static PageResult resultChange(IPage iPage){
        PageResult pageResult=new PageResult();
        pageResult.setNum(iPage.getTotal());
        pageResult.setData(iPage.getRecords());
        return pageResult;
    }

}
