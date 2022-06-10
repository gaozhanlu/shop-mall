package com.gzl.base.manger;

import com.gzl.common.util.email.SendEmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class SendEmail {
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private SendEmailMapper sendEmailMapper;


    public void sendBrandUpdate(){
        Context context = new Context();
        context.setVariable("cloudName","getCloudName");
        context.setVariable("schoolName","SchoolName");
        context.setVariable("brandName","BrandName");
        context.setVariable("brandOff","BrandOff");
        context.setVariable("updateName","UpdateName");


        String title="修改品牌折扣通知";
        String email=" gaozhanlu@inno-chem.com.cn";
        String emailTemplate= templateEngine.process("HelloWord", context);
        //发送邮件

        sendEmailMapper.sendHtmlMail(email, title, emailTemplate);



    }
}
