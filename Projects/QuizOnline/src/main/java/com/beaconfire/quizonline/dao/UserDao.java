package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.dao.jdbc.rowmapper.UserRowMapper;
import com.beaconfire.quizonline.domain.Address;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.domain.jdbc.AddressJdbc;
import com.beaconfire.quizonline.domain.jdbc.UserJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {


    List<User> getAllUsers();

    User getUserById(Integer id);

    User getUserByEmail(String email);

    User createNewUser(String firstName, String lastName, String email, String password, String phone
            , String street, String city, String state, int zipcode, String country);

    int deleteUserById(Integer id);

    int deleteUserByEmail(String email);

    User updateUser(Integer id, String firstName, String lastName, String email, String password,
                    boolean isActive, String phone
            , String street, String city, String state, int zipcode, String country);

    int changeActiveById(int id);

    Address getAddressById(Integer id);


}
