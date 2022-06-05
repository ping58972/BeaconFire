package com.beaconfire.asynchronous.AsyncRestApp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BillingDao {

    public String getBillingInfo(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Billing Info";
    }
}
