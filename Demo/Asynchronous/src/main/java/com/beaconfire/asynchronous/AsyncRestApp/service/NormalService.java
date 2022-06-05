package com.beaconfire.asynchronous.AsyncRestApp.service;

import com.beaconfire.asynchronous.AsyncRestApp.service.entityService.AccountService;
import com.beaconfire.asynchronous.AsyncRestApp.service.entityService.BillingService;
import com.beaconfire.asynchronous.AsyncRestApp.service.entityService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NormalService {

    private UserService userService;
    private AccountService accountService;
    private BillingService billingService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setBillingService(BillingService billingService) {
        this.billingService = billingService;
    }

    public String getAllInfoNonAsync(){
        String userInfo = userService.getUserInfoNonAsync();
        String accountInfo = accountService.getAccountInfoNonAsync();
        String billingInfo = billingService.getBillingInfoNonAsync();
        return userInfo + " " + accountInfo + " " + billingInfo;
    }
}
