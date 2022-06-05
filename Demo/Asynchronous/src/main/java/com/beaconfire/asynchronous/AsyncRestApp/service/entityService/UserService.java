package com.beaconfire.asynchronous.AsyncRestApp.service.entityService;

import com.beaconfire.asynchronous.AsyncRestApp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getUserInfoNonAsync(){
        return userDao.getUserInfo();
    }

    @Async("taskExecutor")
    public CompletableFuture<String> getUserInfoAsync(){
        String userInfo = userDao.getUserInfo();
        return CompletableFuture.completedFuture(userInfo);


        // User user = userDao.getUserById(id)
        // return CompletableFuture.completedFuture(user);
    }
}
