package com.example.mail_test.services;


import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.example.mail_test.bean.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service("mailService")
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;
    @Autowired
    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Mail mail) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom()));
            mimeMessageHelper.setTo(mail.getMailTo());
            mimeMessageHelper.setText(mail.getMailContent());

            mailSender.send(mimeMessageHelper.getMimeMessage());
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom("ping4learn@gmail.com");
//            message.setTo("pink58972@gmail.com");
//            message.setSubject("Just try the best.");
//            message.setText("contesdkf ksjdf.");
//            mailSender.send(message);
            System.out.println("Sending mail successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}

