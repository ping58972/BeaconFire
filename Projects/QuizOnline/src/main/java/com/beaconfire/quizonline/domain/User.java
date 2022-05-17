package com.beaconfire.quizonline.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String faceUrl;
    private int addressId;
    private Address address;
    private boolean isActive;
    private boolean isAdmin;
    private String message;
}
