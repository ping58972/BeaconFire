package com.beaconfire.quizonline.domain;

import lombok.*;

@Getter
@Setter
@ToString
public abstract class Contact {
    private int contactId;
    private String firstName;
    private String lastName;
    private String subject;
    private String message;
}
