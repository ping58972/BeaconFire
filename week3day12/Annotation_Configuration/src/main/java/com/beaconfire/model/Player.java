package com.beaconfire.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("prototype")
public class Player {
    private Coach tennis;
    private Coach golf;

    @Autowired
    private Coach footBall;

    @Autowired
    public Player(Coach tennis) {
        this.tennis = tennis;
    }

    @Autowired
    public void setGolf(Coach golf) {
        this.golf = golf;
    }
    public Coach getGolf() {
        return golf;
    }


}
