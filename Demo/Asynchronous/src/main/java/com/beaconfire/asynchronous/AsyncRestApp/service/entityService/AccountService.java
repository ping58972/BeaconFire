package com.beaconfire.asynchronous.AsyncRestApp.service.entityService;

import com.beaconfire.asynchronous.AsyncRestApp.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AccountService {
    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String getAccountInfoNonAsync(){
        return accountDao.getAccountInfo();
    }

    @Async("taskExecutor")
    public CompletableFuture<String> getAccountInfoAsync(){
        String accountInfo = accountDao.getAccountInfo();
        return CompletableFuture.completedFuture(accountInfo); // return completed CompletableFuture
    }
}
