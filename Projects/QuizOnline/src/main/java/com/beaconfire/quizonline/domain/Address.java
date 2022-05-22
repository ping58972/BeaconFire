package com.beaconfire.quizonline.domain;

import lombok.*;

@Getter
@Setter
@ToString
public abstract class Address {
    private int addressId;
    private String street;
    private String city;
    private String state;
    private int zipcode;
    private String country;
    private String message;
}
