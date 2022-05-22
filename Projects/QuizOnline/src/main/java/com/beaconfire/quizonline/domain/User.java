package com.beaconfire.quizonline.domain;

import lombok.*;

@Getter
@Setter
@ToString
public abstract class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String faceUrl;
    private int addressId;
    private Address address;
    private String street;
    private String city;
    private String state;
    private int zipcode;
    private String country;
    private boolean isActive;
    private boolean isAdmin;
    private String message;

    public void setAddressToUser(Address address) {
        this.setAddress(address);
        this.setCity(address.getCity());
        this.setStreet(address.getStreet());
        this.setState(address.getState());
        this.setCountry(address.getCountry());
        this.setZipcode(address.getZipcode());
    }

}
