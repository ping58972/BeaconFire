package com.beaconfire.pp_webservice_restful.service;

import com.beaconfire.pp_webservice_restful.dao.UserDao;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.hibernate.UserHibernate;
import com.beaconfire.pp_webservice_restful.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
