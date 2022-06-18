package com.bfs.logindemo.service;

import com.bfs.logindemo.dao.UserDao;
import com.bfs.logindemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final UserDao userDao;

    @Autowired
    public LoginService(UserDao userDao) {this.userDao = userDao; }

    public Optional<User> validateLogin(String username, String password) {
        return userDao.validateLogin(username, password);
    }

}
