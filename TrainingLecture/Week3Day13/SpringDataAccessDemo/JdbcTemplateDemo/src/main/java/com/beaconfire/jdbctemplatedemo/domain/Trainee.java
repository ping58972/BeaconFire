package com.beaconfire.jdbctemplatedemo.domain;

public class Trainee {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String ssn;

    public Trainee() {}

    public Trainee(int id, String firstName, String lastName, String phoneNumber, String ssn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
