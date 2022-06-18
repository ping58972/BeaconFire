package com.beaconfire.quizrestful.service;

import com.beaconfire.quizrestful.dao.UserDao;
import com.beaconfire.quizrestful.domain.User;
import com.beaconfire.quizrestful.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
    private UserDao userDaoHibernate;

    @Autowired
    @Qualifier("userDaoHibernateImpl")
    public void setUserDaoHibernate(UserDao userDaoHibernate) {
        this.userDaoHibernate = userDaoHibernate;
    }
    public List<User> getAllUsers() throws UserNotFoundException {
        return userDaoHibernate.getAllUsers();
    }
    public User getUserById(int id) throws UserNotFoundException {
        return userDaoHibernate.getUserById(id);
    }
    @Async("taskExecutor")
    public CompletableFuture<User> getUserByIdAsync(int id) throws UserNotFoundException {
        return CompletableFuture.completedFuture(userDaoHibernate.getUserByIdAsync(id));
    }

    public User createNewUser(User user) throws UserNotFoundException {
        return userDaoHibernate.createNewUser(user);
    }


    public User deleteUserById(int id) throws UserNotFoundException {
        return userDaoHibernate.deleteUserById(id);
    }

    public User changeUserStatus(int id, boolean activate) throws UserNotFoundException {
        return userDaoHibernate.changeUserStatus(id, activate);
    }

}
