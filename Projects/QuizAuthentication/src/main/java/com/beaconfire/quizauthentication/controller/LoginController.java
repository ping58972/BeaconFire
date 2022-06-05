package com.beaconfire.quizauthentication.controller;

import com.beaconfire.quizauthentication.dao.UserDaoImpl;
import com.beaconfire.quizauthentication.domain.request.LoginRequest;
import com.beaconfire.quizauthentication.domain.response.LoginResponse;
import com.beaconfire.quizauthentication.entity.User;
import com.beaconfire.quizauthentication.security.AuthUserDetail;
import com.beaconfire.quizauthentication.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoginController {

    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;
    @Autowired
    UserDaoImpl userDao;
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Autowired
    public void setJwtProvider(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("auth/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        Authentication authentication;

        try{

            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

        } catch (AuthenticationException e){
            throw new BadCredentialsException("Provided credential is invalid.");
        }
        AuthUserDetail authUserDetail = (AuthUserDetail) authentication.getPrincipal();
        String token = jwtProvider.createToken(authUserDetail);
        return LoginResponse.builder()
                .message("Welcome "+ authUserDetail.getUsername())
                .token(token)
                .build();
    }

}
