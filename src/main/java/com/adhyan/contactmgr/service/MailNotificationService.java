package com.adhyan.contactmgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendNotification(String to, String subject, String body) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setFrom("adhyan2095@gmail.com");
        mail.setSubject(subject);
        mail.setText(body);
        javaMailSender.send(mail);
    }
}
