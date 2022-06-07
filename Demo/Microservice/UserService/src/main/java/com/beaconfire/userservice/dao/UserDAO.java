package com.beaconfire.userservice.dao;

import com.beaconfire.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDAO {

    public List<User> getAllUsers(){
        return Arrays.asList(
                User.builder().firstName("Oliver").lastName("Li").email("bli@beaconfireinc.com").build(),
                User.builder().firstName("April").lastName("Huang").email("phuang@beaconfireinc.com").build()
        );
    }

}
