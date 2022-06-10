package com.gzl.common.util.email;

public interface SendEmailMapper {
    /**
     * 发送纯文本邮件
     *  toAddr 收件人
     *  title 标题
     *  content 内容
     */
    void sendTextMail(String toAddr, String title, String content);

    /**
     * 发送 html 邮件
     *  toAddr 收件人
     *  title 标题
     *  content 内容（HTML）
     */
    void sendHtmlMail(String toAddr, String title, String content);

    /**
     *  发送待附件的邮件
     *  toAddr 收件人
     * title 标题
     *  content 内容
     *  filePath 附件地址
     */
    void sendAttachmentsMail(String toAddr, String title, String content, String filePath);

    /**
     *  发送文本中有静态资源（图片）的邮件
     *toAddr 收件人
     * title 标题
     *  content 内容
     *  rscPath 资源路径
     *  rscId 资源id (可能有多个图片)
     */
    void sendInlineResourceMail(String toAddr, String title, String content, String rscPath, String rscId);
}
