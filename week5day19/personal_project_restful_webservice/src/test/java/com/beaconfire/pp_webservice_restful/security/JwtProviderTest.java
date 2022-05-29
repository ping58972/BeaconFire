package com.beaconfire.pp_webservice_restful.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class JwtProviderTest {

    @Mock
    HttpServletRequest request;
    @Mock
    JwtProvider jwtProvider;

    @Test
    void resolveToken() {
         AuthUserDetail authUserDetail = AuthUserDetail.builder()
                .username("username").password("password").build();
        Mockito.when(jwtProvider.resolveToken(request))
                .thenReturn(Optional.ofNullable(authUserDetail));
        assertEquals(authUserDetail, jwtProvider.resolveToken(request).get());
    }
}