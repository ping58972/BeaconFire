package com.beaconfire.emailapp;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@JsonDeserialize
public class Question {

    private Integer questionId;
    private Integer categoryId;
    private String description;
    private String type;
    private Boolean isActive;

    public Question() {
    }

    public Question(Integer questionId, Integer categoryId, String description, String type, Boolean isActive) {
        this.questionId = questionId;
        this.categoryId = categoryId;
        this.description = description;
        this.type = type;
        this.isActive = isActive;
    }
}
