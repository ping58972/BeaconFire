package com.beaconfire.pp_webservice_restful.controller;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;
import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
import com.beaconfire.pp_webservice_restful.domain.hibernate.UserHibernate;
import com.beaconfire.pp_webservice_restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('read')")
    public AllUsersResponse getAllUsers(){
        try{
            return AllUsersResponse.builder().status(ResponseStatus.builder()
                            .success(true).message("Returning all Users.").build())
                    .users(userService.getAllUsers()).build();
        } catch (Exception e){
            return AllUsersResponse.builder().status(ResponseStatus.builder()
                            .success(false).message("Can not return all Users.").build())
                    .users(new ArrayList<>()).build();
        }

    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyAuthority('read')")
    public UserResponse getUserById(@PathVariable int userId) {
        try{
            return UserResponse.builder().status(ResponseStatus.builder()
                            .success(true).message("Returning the User By Id.").build())
                    .user(userService.getUserById(userId)).build();
        }catch (Exception e){
            return UserResponse.builder().status(ResponseStatus.builder()
                            .success(false).message("Can not Returning the User By Id.").build())
                    .user(null).build();
        }

    }

    @PostMapping()
    @PreAuthorize("hasAnyAuthority('write')")
    public UserResponse createNewUser(@RequestBody UserHibernate user) {
        try {
            User newUser = userService.createNewUser(user);
            if(newUser == null){
                throw new RuntimeException("Some thing wrong!");
            }
            return UserResponse.builder().status(ResponseStatus.builder()
                    .success(true).message("Created a new User.")
                    .build()).user(newUser).build();
        } catch (Exception e){
            return UserResponse.builder().status(ResponseStatus.builder()
                            .success(false).message("Can not Create a new user.").build())
                    .user(null).build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('delete')")
    public UserResponse deleteUserById(@PathVariable("id") int id) {
        try {
            User newUser = userService.deleteUserById(id);
            if(newUser == null){
                throw new RuntimeException("Some thing wrong!");
            }
            return UserResponse.builder().status(ResponseStatus.builder()
                    .success(true).message("Delete User success.")
                    .build()).user(newUser).build();
        } catch (Exception e){
            return UserResponse.builder().status(ResponseStatus.builder()
                            .success(false).message("Can not Delete user.").build())
                    .user(null).build();
        }
    }

    @PatchMapping("/{id}/status")
    @PreAuthorize("hasAnyAuthority('update')")
    public UserResponse changeUserStatus(@PathVariable int id, @RequestParam(value="activate", required = true) boolean activate) {
        try {
            User newUser = userService.changeUserStatus(id, activate) ;
            if(newUser == null){
                throw new RuntimeException("Some thing wrong!");
            }
            return UserResponse.builder().status(ResponseStatus.builder()
                    .success(true).message("User Statue changed success.")
                    .build()).user(newUser).build();
        } catch (Exception e){
            return UserResponse.builder().status(ResponseStatus.builder()
                            .success(false).message("Can not change user status.").build())
                    .user(null).build();
        }
    }
}
