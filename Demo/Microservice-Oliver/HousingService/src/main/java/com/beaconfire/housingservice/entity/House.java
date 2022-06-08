package com.beaconfire.housingservice.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class House {
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
