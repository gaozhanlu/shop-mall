package com.gzl.shop.scheduled;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class JobHandler {

    @XxlJob("mobileTasks")
    public void scheduledTasks(String param) {
        //业务统计服务代码，就不列出来了

        log.error("调用");
    }
}
