package com.beaconfire.quizrestful.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewMessageRequest {
    private String title;
    private String description;
}
