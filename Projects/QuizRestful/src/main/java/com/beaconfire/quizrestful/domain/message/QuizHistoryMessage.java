package com.beaconfire.quizrestful.domain.message;

import com.beaconfire.quizrestful.domain.Quiz;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class QuizHistoryMessage implements Serializable {
    String emailFrom;
    String emailTo;
    String subject;
    List<Quiz> history;
    public QuizHistoryMessage(@JsonProperty("emailFrom") String emailFrom,
                              @JsonProperty("emailTo") String emailTo,
                              @JsonProperty("subject") String subject,
                              @JsonProperty("history") List<Quiz> history) {
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.history = history;
    }
}
