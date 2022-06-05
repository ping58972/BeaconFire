package com.beaconfire.asynchronous.AsyncRestApp.service.entityService;

import com.beaconfire.asynchronous.AsyncRestApp.dao.BillingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;

@Service
public class BillingService {
    private BillingDao billingDao;

    @Autowired
    public void setBillingDao(BillingDao billingDao) {
        this.billingDao = billingDao;
    }

    public String getBillingInfoNonAsync(){
        return billingDao.getBillingInfo();
    }

    @Async("taskExecutor")
    public CompletableFuture<String> getBillingInfoAsync(){
        String billingInfo = billingDao.getBillingInfo();
        return CompletableFuture.completedFuture(billingInfo);
    }
}
