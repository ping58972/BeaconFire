package com.beaconfire.emailapp.service;

import com.beaconfire.emailapp.QuizHistoryMessage;
import com.beaconfire.emailapp.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("mailServiceImpl")
public class MailServiceImpl implements MailService{

    private  JavaMailSender mailSender;
    @Autowired
    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(QuizHistoryMessage msg) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper =
                    new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(msg.getSubject());
            mimeMessageHelper.setFrom(new InternetAddress("ping4learn@gmail.com"));
            mimeMessageHelper.setTo(msg.getEmailTo());
            mimeMessageHelper.setText(msg.getHistory().toString());
            mailSender.send(mimeMessageHelper.getMimeMessage());
//            SimpleMailMessage templateSimpleMessage = new SimpleMailMessage();
//        templateSimpleMessage.setFrom("ping4learn@gmail.com");
//            templateSimpleMessage.setTo("pink58972@gmail.com");
//            templateSimpleMessage.setSubject("quizHTry to sending email");
//            templateSimpleMessage.setText(mail.toString());
//            JavaMailSender sender = emailSender.

            System.out.println("send success!");
        }catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
