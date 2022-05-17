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

    public User validateLogin(String email, String password) {

        User testUser = userDao.getUserByEmail(email);
        if (password.equals(testUser.getPassword())) {
            testUser.setMessage("User Login Success!");
            return testUser;
        }
        return testUser;

    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public User createNewUser(User user) {
        return userDao.createNewUser(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.getPhone(), user.getStreet(), user.getCity(),
                user.getState(), user.getZipcode(), user.getCountry());
    }
}
