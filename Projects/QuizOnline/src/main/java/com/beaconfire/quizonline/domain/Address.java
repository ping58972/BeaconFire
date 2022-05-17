package com.beaconfire.quizonline.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private int addressId;
    private String street;
    private String city;
    private String state;
    private int zipcode;
    private String country;
    private String message;
}
