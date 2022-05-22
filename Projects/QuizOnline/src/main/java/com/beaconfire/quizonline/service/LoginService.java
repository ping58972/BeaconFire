package com.beaconfire.quizonline.service;

import com.beaconfire.quizonline.dao.UserDao;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.domain.jdbc.UserJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private UserDao userJdbcDao;

    @Autowired
    public void setUserJdbcDao(@Qualifier("userDaoJdbcImpl")
                               UserDao userJdbcDao) {
        this.userJdbcDao = userJdbcDao;
    }

    public User validateLogin(String email, String password) {

        User testUser = userJdbcDao.getUserByEmail(email);
        if (password.equals(testUser.getPassword())) {
            testUser.setMessage("User Login Success!");
            return testUser;
        }
        return new UserJdbc();

    }

    public User getUserByEmail(String email) {
        return userJdbcDao.getUserByEmail(email);
    }

    public User createNewUser(User user) {
        return userJdbcDao.createNewUser(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.getPhone(), user.getStreet(), user.getCity(),
                user.getState(), user.getZipcode(), user.getCountry());
    }
}
