package com.beaconfire.quizonline.domain;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Choice {
    private int choiceId;
    private int questionId;
    private String choiceDesription;
    private boolean isCorrect;
}
