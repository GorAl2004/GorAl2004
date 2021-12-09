package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component("mailSenderClient")
public class MailSender {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String from;



    public void sendSimpleMessage(String to, String subject, String text) throws MessagingException {

        /*SimpleMailMessage message = new SimpleMailMessage();*/

        MimeMessage messagee = emailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(messagee);

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text,true);
        emailSender.send(messagee);
    }

}
