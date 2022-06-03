package com.beaconfire.emailapp;


import lombok.*;


@Getter
@Setter
@Builder
@ToString
public class Question {

    private Integer questionId;
    private Integer categoryId;
    private String description;
    private String type;
    private Boolean isActive;


}
