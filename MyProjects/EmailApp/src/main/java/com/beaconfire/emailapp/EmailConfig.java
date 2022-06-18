//package com.beaconfire.emailapp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//@Configuration
//public class EmailConfig {
////    @Autowired
////    private Environment env;
//    @Bean
//    public JavaMailSender getMailSender() {
//
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//
//        mailSender.setUsername("ping4learn@gmail.com");
//        mailSender.setPassword("58972P!nk");
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//        mailSender.setJavaMailProperties(props);
//
//        return mailSender;
//    }
//
//    @Bean
//    public SimpleMailMessage templateSimpleMessage(){
//        SimpleMailMessage message = new SimpleMailMessage();
//        return message;
//    }
//}
