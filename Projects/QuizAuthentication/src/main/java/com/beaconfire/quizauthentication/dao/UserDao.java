package com.beaconfire.quizauthentication.dao;


import com.beaconfire.quizauthentication.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> loadUserByEmail(String email);
    List<User> getAllUsers();
}
