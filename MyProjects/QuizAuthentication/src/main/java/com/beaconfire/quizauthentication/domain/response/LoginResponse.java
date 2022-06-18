package com.beaconfire.quizauthentication.domain.response;

import lombok.*;

@Getter
@Setter
@Builder
public class LoginResponse {
    private String message;
    private String token;
}
