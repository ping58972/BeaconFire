package com.bfs.springmvcdemo.service;

import com.bfs.springmvcdemo.dao.UserDao;
import com.bfs.springmvcdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public void createNewUser(User user) {
        userDao.createNewUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
