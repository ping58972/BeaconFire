package com.beaconfire.asynchronous.AsyncRestApp.service;

import com.beaconfire.asynchronous.AsyncRestApp.service.entityService.AccountService;
import com.beaconfire.asynchronous.AsyncRestApp.service.entityService.BillingService;
import com.beaconfire.asynchronous.AsyncRestApp.service.entityService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
    private AccountService accountService;
    private BillingService billingService;
    private UserService userService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setBillingService(BillingService billingService) {
        this.billingService = billingService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getAllInfoAsync(){
        CompletableFuture<String> accountFuture = accountService.getAccountInfoAsync();
        CompletableFuture<String> billingFuture = billingService.getBillingInfoAsync();
        CompletableFuture<String> userFuture = userService.getUserInfoAsync();
        // CompletableFuture<User> userFuture = userService.getUserInfoAsync();
        // CompletableFuture<User> quizFuture = quizService.getQuizInfoAsync();

        CompletableFuture<String> responseFuture = CompletableFuture.allOf(
                accountFuture,
                billingFuture,
                userFuture
        ).thenApply(
                (placeHolder) -> {
            return accountFuture.join() + " " + billingFuture.join() + " " + userFuture.join();


            // CombinedResult.builder
            //  .user(user)
            //  .quiz(quiz)
            //  .build()
        });

        return responseFuture.join();
    }
}


/*
@Builder
@Setter
@Getter
class CombinedResult{
    private User user;
    private List<Quiz> quizzes;
}
*/
