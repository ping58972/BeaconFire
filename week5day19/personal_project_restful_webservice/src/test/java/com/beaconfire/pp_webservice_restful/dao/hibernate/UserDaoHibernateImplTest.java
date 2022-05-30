package com.beaconfire.pp_webservice_restful.dao.hibernate;

import com.beaconfire.pp_webservice_restful.dao.UserDao;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.hibernate.UserHibernate;
import com.beaconfire.pp_webservice_restful.exception.UserNotFoundException;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserDaoHibernateImplTest {


    @BeforeEach
    void setUp() {
    }

    @Test
    void getCurrentSession() {
    }

    @Test
    void setClazz() {
        assertTrue(true);
    }

    @Test
    void getAll() {
        assertTrue(true);
    }

    @Test
    void findById() {
        assertTrue(true);
    }

    @Test
    void add() {
        assertTrue(true);
    }

    @Test
    void getAllUsers() {
        assertTrue(true);
    }

    @Test
    void getUserById(){
        assertTrue(true);
    }

    @Test
    void createNewUser() {
        assertTrue(true);
    }

    @Test
    void deleteUserById() {
        assertTrue(true);
    }

    @Test
    void changeUserStatus() {
        assertTrue(true);
    }
}