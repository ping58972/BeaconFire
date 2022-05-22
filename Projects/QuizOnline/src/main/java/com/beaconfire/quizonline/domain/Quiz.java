package com.beaconfire.quizonline.domain;

import lombok.*;

import java.sql.Timestamp;
import java.util.Map;

@Getter
@Setter
@ToString
public abstract class Quiz {
    private int quizId;
    private String quizName;
    private int userId;
    private String userName;
    private int score;
    private int categoryId;
    private String categoryName;
    private Timestamp startTime;
    private Timestamp endTime;
    private Map<Integer, QuizQuestion> quizQuestionMap;
}
