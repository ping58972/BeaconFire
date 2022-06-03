package com.beaconfire.emailapp;


import lombok.*;


import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@Builder
@ToString
public class Quiz {

    private int quizId;
    private int userId;
    private String quizName;
    private int categoryId;
    private Timestamp startTime;
    private Timestamp endTime;
    private List<Question> questions;

}
