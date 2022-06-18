package com.beaconfire.quizrestful.controller;
import com.beaconfire.quizrestful.domain.*;
import com.beaconfire.quizrestful.domain.common.ResponseStatus;
import com.beaconfire.quizrestful.domain.hibernate.UserHibernate;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import com.beaconfire.quizrestful.exception.UserNotFoundException;
import com.beaconfire.quizrestful.service.QuizService;
import com.beaconfire.quizrestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final QuizService quizService;

    @Autowired
    public UserController(UserService userService, QuizService quizService) {
        this.userService = userService;
        this.quizService = quizService;
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

    @GetMapping("/{userId}/allQuiz")
    @PreAuthorize("hasAnyAuthority('read')")
    public ResponseEntity<UserQuizzesResponse> getAllQuizzesByUserId(@PathVariable int userId)
            throws QuizNotFoundException, UserNotFoundException {
        User user = userService.getUserById(userId);
        System.out.println(user);
        List<Quiz> quizList = quizService.getAllQuizzesByUserId(userId);
        System.out.println(quizList);
        return ResponseEntity.ok(UserQuizzesResponse.builder().status(ResponseStatus.builder()
                        .success(true).message("Returning all Quizzes by User Id - Async.").build())
                .userQuizzes(null).build());

    }
}
