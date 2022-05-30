package com.beaconfire.pp_webservice_restful.controller;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;
import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
import com.beaconfire.pp_webservice_restful.domain.hibernate.UserHibernate;
import com.beaconfire.pp_webservice_restful.exception.UserNotFoundException;
import com.beaconfire.pp_webservice_restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<AllUsersResponse> getAllUsers() throws UserNotFoundException {

        return ResponseEntity.ok(AllUsersResponse.builder().status(ResponseStatus.builder()
                        .success(true).message("Returning all Users.").build())
                .users(userService.getAllUsers()).build());
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyAuthority('read')")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int userId) throws UserNotFoundException {
            return ResponseEntity.ok(UserResponse.builder().status(ResponseStatus.builder()
                            .success(true).message("Returning the User By Id.").build())
                    .user(userService.getUserById(userId)).build());
    }

    @PostMapping()
    @PreAuthorize("hasAnyAuthority('write')")
    public ResponseEntity<UserResponse> createNewUser(@RequestBody UserHibernate user) throws UserNotFoundException {
        User newUser = userService.createNewUser(user);
        if(newUser == null){
            throw new UserNotFoundException("Some thing wrong!");
        }
            return ResponseEntity.ok(UserResponse.builder().status(ResponseStatus.builder()
                    .success(true).message("Created a new User.")
                    .build()).user(newUser).build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('delete')")
    public ResponseEntity<UserResponse> deleteUserById(@PathVariable("id") int id) throws UserNotFoundException {
            User newUser = userService.deleteUserById(id);
            if(newUser == null){
                throw new UserNotFoundException("Some thing wrong!");
            }
            return ResponseEntity.ok(UserResponse.builder().status(ResponseStatus.builder()
                    .success(true).message("Delete User success.")
                    .build()).user(newUser).build());
    }

    @PatchMapping("/{id}/status")
    @PreAuthorize("hasAnyAuthority('update')")
    public ResponseEntity<UserResponse> changeUserStatus(@PathVariable int id, @RequestParam(value="activate", required = true) boolean activate) throws UserNotFoundException {

            User newUser = userService.changeUserStatus(id, activate) ;
            if(newUser == null){
                throw new UserNotFoundException("Some thing wrong!");
            }
            return ResponseEntity.ok(UserResponse.builder().status(ResponseStatus.builder()
                    .success(true).message("User Statue changed success.")
                    .build()).user(newUser).build());
    }
}
