package com.beaconfire.quizonline.dao.hibernate;

import com.beaconfire.quizonline.dao.UserDao;
import com.beaconfire.quizonline.domain.Address;
import com.beaconfire.quizonline.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDaoHibernateImpl")
public class UserDaoHibernateImpl implements UserDao {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User createNewUser(String firstName, String lastName, String email, String password, String phone, String street, String city, String state, int zipcode, String country) {
        return null;
    }

    @Override
    public int deleteUserById(Integer id) {
        return 0;
    }

    @Override
    public int deleteUserByEmail(String email) {
        return 0;
    }

    @Override
    public User updateUser(Integer id, String firstName, String lastName, String email, String password, boolean isActive, String phone, String street, String city, String state, int zipcode, String country) {
        return null;
    }

    @Override
    public int changeActiveById(int id) {
        return 0;
    }

    @Override
    public Address getAddressById(Integer id) {
        return null;
    }
}
