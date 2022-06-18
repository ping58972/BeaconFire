package com.beaconfire.emailapp;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@JsonDeserialize
public class QuizHistoryMessage implements Serializable {
    String emailFrom;
    String emailTo;
    String subject;
    List<Quiz> history;

    public QuizHistoryMessage() {
    }

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
