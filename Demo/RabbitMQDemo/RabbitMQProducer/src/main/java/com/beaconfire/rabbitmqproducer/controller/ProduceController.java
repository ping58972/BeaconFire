package com.beaconfire.rabbitmqproducer.controller;

import com.beaconfire.rabbitmqproducer.domain.message.SimpleMessage;
import com.beaconfire.rabbitmqproducer.domain.request.NewMessageRequest;
import com.beaconfire.rabbitmqproducer.util.SerializeUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")
public class ProduceController {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("produce/direct")
    public ResponseEntity<String> produceDirect(@RequestBody NewMessageRequest request,
                                          @RequestParam String routingKey){

        SimpleMessage newMessage = SimpleMessage.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();

        String jsonMessage = SerializeUtil.serialize(newMessage);


        rabbitTemplate.convertAndSend("TrainingDirectExchange", routingKey, jsonMessage);

        return ResponseEntity.ok("Message Sent");
    }

    @PostMapping("produce/fanout")
    public ResponseEntity<String> produceFanout(@RequestBody NewMessageRequest request,
                                          @RequestParam String routingKey) {
        SimpleMessage newMessage = SimpleMessage.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();

        rabbitTemplate.convertAndSend("TrainingFanOutExchange", routingKey, newMessage.toString());

        return ResponseEntity.ok("Message Sent");
    }

    @PostMapping("produce/topic")
    public ResponseEntity<String> produceTopic(@RequestBody NewMessageRequest request,
                                               @RequestParam String routingKey) {
        SimpleMessage newMessage = SimpleMessage.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();

        rabbitTemplate.convertAndSend("TrainingTopicExchange", routingKey, newMessage.toString());

        return ResponseEntity.ok("Message Sent");
    }



}
