package com.beaconfire.asynchronous.AsyncRestApp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public String getUserInfo(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "User Info";
    }
}
