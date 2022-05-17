package com.beaconfire.quizonline.service;

import com.beaconfire.quizonline.dao.UserDao;
import com.beaconfire.quizonline.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final UserDao userDao;
    @Autowired
    public LoginService(UserDao userDao) {
        this.userDao = userDao;
    }
    public User validateLogin(String email, String password){

            User testUser = userDao.getUserByEmail(email);
            if(password.equals(testUser.getPassword())){
                testUser.setMessage("User Login Success!");
                return testUser;
            }
        return testUser;

    }
}
