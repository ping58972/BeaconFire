package com.beaconfire.rabbitmqproducer.scheduling;

import com.beaconfire.rabbitmqproducer.domain.message.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTask {

    private RabbitTemplate rabbitTemplate;



    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessageEverySecond(){
        SimpleMessage newMessage = SimpleMessage.builder()
                .title("Scheduled Message")
                .description("Current local date time: " + LocalDateTime.now())
                .build();
        rabbitTemplate.convertAndSend("TrainingDirectExchange", "directToQueue1", newMessage.toString());
    }
}
