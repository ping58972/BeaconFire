package com.beaconfire.quizonline.domain;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public abstract class Feedback {
    private int feedbackId;
    private int userId;
    private String message;
    private int rating;
    private Timestamp feedbackTime;
}
