package com.beaconfire.quizonline.domain;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
public abstract class Question {
    private int questionId;
    private int categoryId;
    private String categoryName;
    private String description;
    private String type;
    private boolean isActive;
    private Map<Integer, Choice> choiceMap;
    private String correctAnswer;
    private String choice1;
    private String choice2;
    private String choice3;
    private int correctAnswerId;
    private int choiceId1;
    private int choiceId2;
    private int choiceId3;

}
