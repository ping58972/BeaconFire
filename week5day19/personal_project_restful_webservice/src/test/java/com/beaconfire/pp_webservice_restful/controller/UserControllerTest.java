package com.beaconfire.pp_webservice_restful.controller;

import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
import com.beaconfire.pp_webservice_restful.domain.hibernate.UserHibernate;
import com.beaconfire.pp_webservice_restful.exception.UserNotFoundException;
import com.beaconfire.pp_webservice_restful.security.AuthUserDetail;
import com.beaconfire.pp_webservice_restful.security.JwtProvider;
import com.beaconfire.pp_webservice_restful.service.UserService;
import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Filter;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(controllers = UserController.class)
class UserControllerTest {


    @MockBean
    private UserService userService;
    @Mock
    HttpServletRequest request;
    @MockBean
    private JwtProvider jwtProvider;
    @Spy
    private List<User> usersSpy = new ArrayList<>();

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getAllUsers() throws Exception {
//        List<GrantedAuthority> authorities = Arrays.asList(
//                new SimpleGrantedAuthority("read"),
//                new SimpleGrantedAuthority("write"),
//                new SimpleGrantedAuthority("update"),
//                new SimpleGrantedAuthority("delete")
//        );
//        AuthUserDetail authUserDetail = AuthUserDetail.builder().username("admin@qiuz.com")
//                .authorities(authorities).password("admin").build();
//        Optional<AuthUserDetail> authUserDetailOptional = Optional.of(authUserDetail);
//        Mockito.when(jwtProvider.resolveToken(request)).thenReturn(authUserDetailOptional);
        User userExpect = UserHibernate.builder().userId(1).addressId(10).build();
        usersSpy.add(userExpect);
        Mockito.when(userService.getAllUsers()).thenReturn(usersSpy);
        AllUsersResponse allUsersResponse = AllUsersResponse.builder()
                .status(ResponseStatus.builder().success(true).message("Returning all Users.").build())
                .users(usersSpy).build();
        Gson gson = new Gson();
        String json = gson.toJson(allUsersResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk()
                )
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(json))
                ;
        Mockito.verify(userService, Mockito.times(1)).getAllUsers();
//       MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//               .get("/user").contentType(MediaType.APPLICATION_JSON).content(json)).andReturn();
//        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    void getUserById() {
    }

    @Test
    void createNewUser() {
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void changeUserStatus() {
    }
}