package com.example.mail_test;

import com.example.mail_test.bean.Mail;
import com.example.mail_test.services.MailService;
import com.example.mail_test.services.MailServiceImpl;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MailTestApplication {

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.setMailFrom("ping4learn@gmail.com");
        mail.setMailTo("pink58972@gmail.com");
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent("Learn How to send Email using Spring Boot!!!");

        ApplicationContext ctx = SpringApplication.run(MailTestApplication.class, args);
        MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendEmail(mail);

    }

//    @Autowired
//    private MailServiceImpl mailService;
//    public static void main(String[] args) {
//        SpringApplication.run(MailTestApplication.class, args);
//    }
//    @EventListener(ApplicationReadyEvent.class)
//    public void sendMail(){
//                Mail mail = new Mail();
//        mail.setMailFrom("ping4learn@gmail.com");
//        mail.setMailTo("pink58972@gmail.com");
//        mail.setMailSubject("Spring Boot - Email Example");
//        mail.setMailContent("Learn How to send Email using Spring Boot!!!");
//        mailService.sendEmail(mail);
//    }

}
