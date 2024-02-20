package com.lesterlin.bigevent.service.impl;

import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SendMailTest {
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("big-event<newa5812763@gmail.com>");
        message.setTo("newa5812763@gmail.com");
        message.setSubject("Hello Lester");
        message.setText("這是一封測式信件!");

        mailSender.send(message);
    }

    @Test
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("big-event<newa5812763@gmail.com>");
        helper.setTo("newa5812763@gmail.com");
        helper.setSubject("Hello Lester 嵌入靜態資源");
        helper.setText("<html><body><a href=\"https://www.w3schools.com/\">w3schools</a></body></html>", true);

        mailSender.send(mimeMessage);
    }
}