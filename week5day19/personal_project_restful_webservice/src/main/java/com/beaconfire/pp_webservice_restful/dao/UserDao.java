package com.beaconfire.pp_webservice_restful.dao;

import com.beaconfire.pp_webservice_restful.domain.AllQuizResponse;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(int id);
    User createNewUser(User user);
    User deleteUserById(int id);
    User changeUserStatus(int id, boolean activate);

}
