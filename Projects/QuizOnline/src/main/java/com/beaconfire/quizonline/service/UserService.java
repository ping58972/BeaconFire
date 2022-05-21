package com.beaconfire.quizonline.service;

import java.util.*;

import com.beaconfire.quizonline.dao.UserDao;
import com.beaconfire.quizonline.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public User updateUser(User newUser) {
        return userDao.updateUser(newUser.getUserId(), newUser.getFirstName(),
                newUser.getLastName(), newUser.getEmail(), newUser.getPassword(), newUser.isActive(),
                newUser.getPhone(), newUser.getStreet(), newUser.getCity(), newUser.getState(),
                newUser.getZipcode(), newUser.getCountry());
    }

    public boolean changeActiveUserById(int id) {
        return 1 == userDao.changeActiveById(id);
    }
}
