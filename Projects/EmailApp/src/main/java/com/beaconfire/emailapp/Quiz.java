package com.beaconfire.emailapp;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;


import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@Builder
@ToString
@JsonDeserialize
public class Quiz {

    private int quizId;
    private int userId;
    private String quizName;
    private int categoryId;
    private Timestamp startTime;
    private Timestamp endTime;
    private List<Question> questions;

    public Quiz() {
    }

    public Quiz(int quizId, int userId, String quizName, int categoryId, Timestamp startTime, Timestamp endTime, List<Question> questions) {
        this.quizId = quizId;
        this.userId = userId;
        this.quizName = quizName;
        this.categoryId = categoryId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.questions = questions;
    }
}
