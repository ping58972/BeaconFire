package com.beaconfire.quizonline.domain;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Feedback {
    private int feedbackId;
    private int userId;
    private String message;
    private int rating;
    private Timestamp feedbackTime;
}
