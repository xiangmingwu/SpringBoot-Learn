package com.wuxm.mail.controller;

import com.wuxm.mail.service.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    private static final String FROM_MAIL = "XXX@qq.com";
    private static final String TO_MAIL = "XXX@qq.com";
    private static final String SUBJECT = "测试";
    private static final String TEXT = "学习这件事不在乎有没有人教你~";

    /**
     * 发送简单邮件
     */
    @GetMapping("/sendSimpleMail")
    public void sendSimpleMail() {
        String suffix = "sendSimpleMail";

        mailService.sendSimpleMail(FROM_MAIL, TO_MAIL, SUBJECT.concat(suffix), TEXT.concat(suffix));
    }

    /**
     * 发送复杂邮件（文本+图片+附件）
     */
    @GetMapping("/sendMimeMail")
    public ResponseEntity<String> sendMimeMail() {
        String suffix = "sendMimeMail";

        return mailService.sendMimeMail(FROM_MAIL, TO_MAIL, SUBJECT.concat(suffix),
                "<h3>" + TEXT + "</h3><br>" +
                        "测试一下<br>" +
                        "<img src='cid:logo'>");
    }

    /**
     * 发送模板邮件
     */
    @GetMapping("/sendTemplateMail")
    public ResponseEntity<String> sendTemplateMail() {
        String suffix = "sendTemplateMail";

        Context context = new Context();
        context.setVariable("username", "X123X");

        return mailService.sendTemplateMail(FROM_MAIL, TO_MAIL, SUBJECT.concat(suffix), context);
    }
}
