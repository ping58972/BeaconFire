package com.beaconfire.emailapp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class RabbitConfig {
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }
    Queue emailQueue(){
        return QueueBuilder.durable("emailQueue").build();
    }
    Queue simpleQueue(){
        return QueueBuilder.durable("simpleQueue").build();
    }
    @Bean
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer messageListenerContainer =
                new SimpleMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory());
        messageListenerContainer.setQueues(emailQueue(), simpleQueue());
        messageListenerContainer.setMessageListener(new EmailListener());
        return messageListenerContainer;
    }
}
