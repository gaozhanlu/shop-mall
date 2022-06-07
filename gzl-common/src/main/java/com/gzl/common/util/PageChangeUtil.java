package com.gzl.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gzl.common.packagemodel.PageResult;
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
