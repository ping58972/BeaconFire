package com.beaconfire.quizonline.domain;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question {
    private int questionId;
    private int categoryId;
    private String description;
    private String type;
    private boolean isActive;
    private Map<Integer, Choice> choiceMap;
}
