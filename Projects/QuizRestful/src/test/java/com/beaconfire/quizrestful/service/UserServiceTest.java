package com.beaconfire.quizrestful.service;

import com.beaconfire.quizrestful.dao.UserDao;
import com.beaconfire.quizrestful.domain.User;
import com.beaconfire.quizrestful.domain.hibernate.UserHibernate;
import com.beaconfire.quizrestful.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserDao userDao;
    @InjectMocks
    UserService userService;
    @Spy
    List<User> usersSpy = new ArrayList<>();

    @Test
    void getAllUsers() throws UserNotFoundException {
        User userExpected = UserHibernate.builder().userId(-1).build();
        usersSpy.add(userExpected);
        Mockito.when(usersSpy.size()).thenReturn(2);
        Mockito.when(userDao.getAllUsers()).thenReturn(usersSpy);
        assertEquals(usersSpy, userService.getAllUsers());
        assertEquals(2, usersSpy.size());
        Mockito.verify(userDao, Mockito.times(1)).getAllUsers();
    }


    @Test
    void getUserById() throws UserNotFoundException {
        User user = UserHibernate.builder().userId(1).email("id@email.com").addressId(20).build();
        Mockito.when(userDao.getUserById(1)).thenReturn(user);
        assertEquals(user, userService.getUserById(1));
        Mockito.verify(userDao, Mockito.times(1)).getUserById(1);
    }
    @Test
    void getUserById_handleException() throws UserNotFoundException {
        UserNotFoundException expectedException = new UserNotFoundException("User Not found");
        Mockito.when(userDao.getUserById(-1)).thenThrow(expectedException);
        assertThrows(UserNotFoundException.class, ()->userService.getUserById(-1));
        Mockito.verify(userDao, Mockito.times(1)).getUserById(-1);
    }

    @Test
    void createNewUser() throws UserNotFoundException {
        User userExpected= UserHibernate.builder().userId(100).email("email@email.com").addressId(10).build();
        User createdUser = UserHibernate.builder().email("email@email.com").build();
        Mockito.when(userDao.createNewUser(createdUser)).thenReturn(userExpected);
        assertEquals(userService.createNewUser(createdUser), userExpected);
        Mockito.verify(userDao, Mockito.times(1)).createNewUser(createdUser);
    }

    @Test
    void deleteUserById() throws UserNotFoundException {
        int userId = 19;
        User userExpected = UserHibernate.builder().userId(userId).build();
        Mockito.when(userDao.deleteUserById(userId)).thenReturn(userExpected);
        assertEquals(userService.deleteUserById(userId), userExpected);
        Mockito.verify(userDao, Mockito.times(1)).deleteUserById(userId);
    }
    @Test
    void deleteUserById_handleException() throws UserNotFoundException {
        UserNotFoundException expectedException = new UserNotFoundException("User Not found");
        Mockito.when(userDao.deleteUserById(-1)).thenThrow(expectedException);
        assertThrows(UserNotFoundException.class, ()->userService.deleteUserById(-1));
        Mockito.verify(userDao, Mockito.times(1)).deleteUserById(-1);
    }

    @Test
    void changeUserStatus() throws UserNotFoundException {
        int userId = 19;
        boolean activate = false;
        User userExpected = UserHibernate.builder().userId(userId).isActive(activate).build();
        Mockito.when(userDao.changeUserStatus(userId, activate)).thenReturn(userExpected);
        assertEquals(userExpected, userService.changeUserStatus(userId, activate));
        Mockito.verify(userDao, Mockito.times(1)).changeUserStatus(userId, activate);
    }
    @Test
    void changeUserStatus_handleException() throws UserNotFoundException {
        UserNotFoundException expectedException = new UserNotFoundException("User Not found");
        Mockito.when(userDao.changeUserStatus(-1, false)).thenThrow(expectedException);
        assertThrows(UserNotFoundException.class, ()->userService.changeUserStatus(-1, false));
        Mockito.verify(userDao, Mockito.times(1)).changeUserStatus(-1, false);
    }
}