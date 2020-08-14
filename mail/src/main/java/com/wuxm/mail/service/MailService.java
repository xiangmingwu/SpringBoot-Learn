package com.wuxm.mail.service;

import org.springframework.http.ResponseEntity;
import org.thymeleaf.context.Context;

public interface MailService {

    /**
     * 发送简单电子邮件
     *
     * @param from    发送人
     * @param to      接收人
     * @param subject 主题
     * @param text    内容
     */
    void sendSimpleMail(String from, String to, String subject, String text);

    /**
     * 发送邮件
     *
     * @param from    发送人
     * @param to      接收人
     * @param subject 主题
     * @param text    内容
     * @return String
     */
    ResponseEntity<String> sendMimeMail(String from, String to, String subject, String text);


    /**
     * 发送模板邮件
     *
     * @param from    发送人
     * @param to      接收人
     * @param subject 主题
     * @param context 内容
     * @return String
     */
    ResponseEntity<String> sendTemplateMail(String from, String to, String subject, Context context);
}
