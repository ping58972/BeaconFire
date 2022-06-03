package com.beaconfire.emailapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailListener implements MessageListener {
    @Autowired
    private JavaMailSender emailSender;
    @Override
    public void onMessage(Message message) {

        SimpleMailMessage smm = new SimpleMailMessage();
        String json = new String(message.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        QuizHistoryMessage quizHistoryMessage = null;
        try {
            quizHistoryMessage = objectMapper.readValue(json, QuizHistoryMessage.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if(quizHistoryMessage == null){
            throw new RuntimeException("quiz History message null");
        }
        smm.setFrom(quizHistoryMessage.email);
        smm.setTo("trainer@beaconfireinc.com");
        smm.setSubject(quizHistoryMessage.subject);
        smm.setText(quizHistoryMessage.getHistory().toString());
        emailSender.send(smm);
        System.out.println("Sent Email info "+ message.getMessageProperties()
                .getConsumerQueue() + ": " + quizHistoryMessage
        );
    }
}
