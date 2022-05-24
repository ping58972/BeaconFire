package com.beaconfire.pp_webservice_restful.controller;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;
import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
import com.beaconfire.pp_webservice_restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public AllUsersResponse getAllUsers(){

        return AllUsersResponse.builder().status(ResponseStatus.builder()
                        .success(true).message("Returning all Users.").build())
                .users(userService.getAllUsers()).build();
    }


    public UserResponse getUserById(int id) {
        return null;
    }


    public UserResponse createNewUser(User user) {
        return null;
    }


    public UserResponse deleteUserById(int id) {
        return null;
    }


    public UserResponse changeUserStatus(int id, boolean activate) {
        return null;
    }
}
