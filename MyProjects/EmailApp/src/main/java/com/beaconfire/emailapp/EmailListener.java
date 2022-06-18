package com.beaconfire.emailapp;

import com.beaconfire.emailapp.service.MailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;


public class EmailListener implements MessageListener{
    private MailService mailService;
    @Autowired
    public EmailListener(MailService mailService) {
        this.mailService = mailService;
    }

    private static ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onMessage(Message message) {
//        String json = new String(message.getBody());
//        SimpleMessage simpleMessage = SimpleMessage.builder()
//                .title("try by Ping").description(json)
//                .build();
//        try {
//            mailService.sendEmail(simpleMessage);
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        try {
//            JsonNode jsonNode = objectMapper.readTree(json);
//            qhm = objectMapper.treeToValue(jsonNode,
//                    QuizHistoryMessage.class);
//            qhm.getHistory().forEach(System.out::println);
//            System.out.println("this is Json: "+jsonNode.get("history"));
//            SimpleMessage sm = objectMapper.treeToValue(jsonNode,
//                    SimpleMessage.class);
//            System.out.println(sm.toString());
            QuizHistoryMessage qhm = objectMapper.reader()
                    .forType(QuizHistoryMessage.class)
                            .readValue(message.getBody());
            mailService.sendEmail(qhm);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
