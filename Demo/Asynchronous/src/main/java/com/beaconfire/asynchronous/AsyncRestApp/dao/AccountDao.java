package com.beaconfire.asynchronous.AsyncRestApp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    public String getAccountInfo(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Account Info";
    }
}
