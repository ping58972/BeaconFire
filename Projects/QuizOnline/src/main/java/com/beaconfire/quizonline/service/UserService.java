package com.beaconfire.quizonline.service;

import java.util.*;

import com.beaconfire.quizonline.dao.UserDao;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.domain.hibernate.UserHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userJdbcDao;
    private UserDao userHibernateDao;

    @Autowired
    @Qualifier("userDaoHibernateImpl")
    public void setUserHibernateDao(UserDao userHibernateDao) {
        this.userHibernateDao = userHibernateDao;
    }

    @Autowired
    @Qualifier("userDaoJdbcImpl")
    public void setUserJdbcDao(UserDao userJdbcDao) {
        this.userJdbcDao = userJdbcDao;
    }

    public List<User> getAllUsers() {

//        return userJdbcDao.getAllUsers();
        return userHibernateDao.getAllUsers();
    }

    public User getUserById(int id) {

//        return userJdbcDao.getUserById(id);
        return userHibernateDao.getUserById(id);
    }

    public User updateUser(User newUser) {
        return userHibernateDao.updateUser(newUser.getUserId(), newUser.getFirstName(),
                newUser.getLastName(), newUser.getEmail(), newUser.getPassword(), newUser.isActive(),
                newUser.getPhone(), newUser.getStreet(), newUser.getCity(), newUser.getState(),
                newUser.getZipcode(), newUser.getCountry());
//        return userJdbcDao.updateUser(newUser.getUserId(), newUser.getFirstName(),
//                newUser.getLastName(), newUser.getEmail(), newUser.getPassword(), newUser.isActive(),
//                newUser.getPhone(), newUser.getStreet(), newUser.getCity(), newUser.getState(),
//                newUser.getZipcode(), newUser.getCountry());
    }

    public boolean changeActiveUserById(int id) {

//        return 1 == userJdbcDao.changeActiveById(id);
        return 1 == userHibernateDao.changeActiveById(id);
    }
}
