package com.beaconfire.quizrestful.controller;

import com.beaconfire.quizrestful.domain.message.SimpleMessage;
import com.beaconfire.quizrestful.domain.request.NewMessageRequest;
import com.beaconfire.quizrestful.util.SerializeUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("message")
public class EmailProduceController {
    private RabbitTemplate rabbitTemplate;
    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @PostMapping("/produce/direct")
    public ResponseEntity<String> produceDirect(@RequestBody NewMessageRequest request,
                                                @RequestParam String routingKey){
        SimpleMessage newMessage = SimpleMessage.builder()
                .title(request.getTitle()).description(request.getDescription())
                .build();
        String jsonMessage = SerializeUtil.serializeSimple(newMessage);
        rabbitTemplate.convertAndSend("emailExchange", routingKey, jsonMessage);
        return ResponseEntity.ok("Message Sent.");
    }
    @PostMapping("produce/fanout")
    public ResponseEntity<String> produceFanout(@RequestBody NewMessageRequest request,
                                                @RequestParam String routingKey) {
        SimpleMessage newMessage = SimpleMessage.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();

        rabbitTemplate.convertAndSend("simpleExchange", routingKey, newMessage.toString());

        return ResponseEntity.ok("Message Sent");
    }

    @PostMapping("produce/topic")
    public ResponseEntity<String> produceTopic(@RequestBody NewMessageRequest request,
                                               @RequestParam String routingKey) {
        SimpleMessage newMessage = SimpleMessage.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();

        rabbitTemplate.convertAndSend("emailExchange", routingKey, newMessage.toString());

        return ResponseEntity.ok("Message Sent");
    }
}
