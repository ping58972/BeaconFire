package com.beaconfire.quizonline.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuizQuestion {
    private int qqId;
    private int quizId;
    private int questionId;
    private Question question;
    private int userChoiceId;
    private String userShortAnswer;
    private int orderNum;
    private boolean isCorrect;
    private String message;
    private boolean isMarked;
}
