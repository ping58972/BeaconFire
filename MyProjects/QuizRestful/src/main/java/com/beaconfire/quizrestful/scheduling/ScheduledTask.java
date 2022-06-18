package com.beaconfire.quizrestful.scheduling;

import com.beaconfire.quizrestful.domain.Quiz;
import com.beaconfire.quizrestful.domain.hibernate.QuizHibernate;
import com.beaconfire.quizrestful.domain.message.QuizHistoryMessage;
import com.beaconfire.quizrestful.domain.message.SimpleMessage;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import com.beaconfire.quizrestful.service.QuizService;
import com.beaconfire.quizrestful.util.SerializeUtil;
import com.google.gson.Gson;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ScheduledTask {
    private RabbitTemplate rabbitTemplate;
    private QuizService quizService;
    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }
    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

//    @Scheduled(fixedRate = 10000)
    public void sendMessageEverySecond(){
        SimpleMessage newMessage = SimpleMessage.builder()
                .title("Schedulted Message each 1s")
                .description("Current local date time: "
                        +  LocalDateTime.now()
                )
                .build();
//        String jsonMessage = SerializeUtil.serializeSimple(newMessage);
        rabbitTemplate.convertAndSend("simpleExchange",
                "Ping", newMessage);
    }
//    @Scheduled(fixedRate = 5000)
//    @Scheduled(cron = "0 0 18 ? * * *")
    public void sendEmailEverySixPM() throws QuizNotFoundException {
       List<Quiz> quizzes = quizService.getAllQuizzesByUserId_trans(2);
        QuizHistoryMessage quizHM = QuizHistoryMessage.builder()
                .emailFrom("ping4lean@gmail.com")
                .emailTo("pink58972@gmail.com")
                .subject("Ping submit Quiz Everyday 6 PM.")
                .history(quizzes)
                .build();
//        String jsonMessage = SerializeUtil.serializeQuiz(quizHM);
        rabbitTemplate.convertAndSend("emailExchange",
                "Ping", quizHM);
    }
}
