package com.beaconfire.model;

public class Player {
    private Coach tennis;
    private Coach golf;
    private Coach footBall;

    public Player() {}

    public Player(Coach tennis) {
        this.tennis = tennis;
    }

    public Coach getTennis() {
        return tennis;
    }

    public void setTennis(Coach tennis) {
        this.tennis = tennis;
    }

    public Coach getGolf() {
        return golf;
    }

    public void setGolf(Coach golf) {
        this.golf = golf;
    }

    public Coach getFootBall() {
        return footBall;
    }

    public void setFootBall(Coach footBall) {
        this.footBall = footBall;
    }
}
