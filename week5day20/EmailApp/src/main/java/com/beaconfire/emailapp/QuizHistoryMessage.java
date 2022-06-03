package com.beaconfire.quizrestful.domain.message;

import com.beaconfire.quizrestful.domain.Quiz;
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
    String email;
    String subject;
    List<Quiz> history;
}
