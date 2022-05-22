package com.beaconfire.quizonline.domain;

import lombok.*;

@Getter
@Setter
@ToString
public abstract class Choice {
    private int choiceId;
    private int questionId;
    private String choiceDesription;
    private boolean isCorrect;
}
