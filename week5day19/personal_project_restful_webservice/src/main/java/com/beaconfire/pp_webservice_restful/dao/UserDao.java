package com.beaconfire.pp_webservice_restful.dao;

import com.beaconfire.pp_webservice_restful.domain.AllQuizResponse;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;
import com.beaconfire.pp_webservice_restful.exception.UserNotFoundException;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers() throws UserNotFoundException;
    User getUserById(int id) throws UserNotFoundException;
    User createNewUser(User user) throws UserNotFoundException;
    User deleteUserById(int id) throws UserNotFoundException;
    User changeUserStatus(int id, boolean activate) throws UserNotFoundException;

}
