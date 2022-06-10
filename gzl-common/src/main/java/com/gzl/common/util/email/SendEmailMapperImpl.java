package com.gzl.common.util.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.File;

@Service
@Slf4j
public class SendEmailMapperImpl implements SendEmailMapper{
    
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username:}")
    private String senderPerson;
 

    public Boolean senderMail(){
        Boolean isOpenEmailNum = true;
        return isOpenEmailNum;
    };

    @Override
    public void sendTextMail(String toAddr, String title, String content) {
        // 纯文本邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        if (!senderMail()){
            return;
        }
        message.setFrom(senderPerson);
        message.setTo(toAddr);
        message.setSubject(title);
        message.setText(content);
        try {
            mailSender.send(message);
            if (log.isInfoEnabled()) {
                log.info("Text邮件已经发送。");
            }
        } catch (Exception e) {
            log.error("发送Text邮件时发生异常！", e);
        }

    }

    @Override
    public void sendHtmlMail(String toAddr, String title, String content) {
        // html 邮件对象
        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            if (!senderMail()){
                return;
            }
            helper.setFrom(senderPerson);
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);

            mailSender.send(message);
            if (log.isInfoEnabled()) {
                log.info("html邮件发送成功");
            }
        } catch (MessagingException e) {
            log.error("发送html邮件时发生异常！", e);
        }

    }

    @Override
    public void sendAttachmentsMail(String toAddr, String title, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            if (!senderMail()){
                return;
            }
            helper.setFrom(senderPerson);
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            if (log.isInfoEnabled()) {
                log.info("带附件的邮件已经发送。");
            }
        } catch (MessagingException e) {
            log.error("发送带附件的邮件时发生异常！", e);
        }

    }

    @Override
    public void sendInlineResourceMail(String toAddr, String title, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            if (!senderMail()){
                return;
            }
            helper.setFrom(senderPerson);
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            if (log.isInfoEnabled()) {
                log.info("嵌入静态资源的邮件已经发送。");
            }
        } catch (MessagingException e) {
            log.error("发送嵌入静态资源的邮件时发生异常！", e);
        }

    }

}
