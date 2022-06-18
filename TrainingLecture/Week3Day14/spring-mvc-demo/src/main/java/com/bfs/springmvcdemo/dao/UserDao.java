package com.bfs.springmvcdemo.dao;

import com.bfs.springmvcdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    private static final List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(1, "user1", "pass1"));
        users.add(new User(2, "user2", "pass2"));
        users.add(new User(3, "user3", "pass3"));
    }

    public User getUserById(int id) {
        return users.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(new User(-1, "invalid username", "invalid password"));
    }

    public User getUserByUsername(String username) {
        return users.stream()
                .filter(a -> a.getUsername().equals(username))
                .findFirst()
                .orElse(new User(-1, "invalid username", "invalid password"));
    }

    public void createNewUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
