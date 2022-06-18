package com.beaconfire.quizrestful.dao;

import com.beaconfire.quizrestful.domain.User;
import com.beaconfire.quizrestful.exception.UserNotFoundException;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserDao {
    List<User> getAllUsers() throws UserNotFoundException;
    User getUserById(int id) throws UserNotFoundException;
    User createNewUser(User user) throws UserNotFoundException;
    User deleteUserById(int id) throws UserNotFoundException;
    User changeUserStatus(int id, boolean activate) throws UserNotFoundException;
    User getUserByIdAsync(int id) throws UserNotFoundException;

}
