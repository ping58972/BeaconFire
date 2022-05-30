package com.beaconfire.pp_webservice_restful.controller;

import com.beaconfire.pp_webservice_restful.dao.UserDao;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;
import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
import com.beaconfire.pp_webservice_restful.domain.hibernate.UserHibernate;
import com.beaconfire.pp_webservice_restful.exception.UserNotFoundException;
import com.beaconfire.pp_webservice_restful.security.AuthUserDetail;
import com.beaconfire.pp_webservice_restful.security.JwtProvider;
import com.beaconfire.pp_webservice_restful.service.UserService;
import com.google.gson.Gson;
import org.hibernate.SessionFactory;
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
import org.springframework.test.web.servlet.request.RequestPostProcessor;
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
    UserService userService;
    @Mock
    HttpServletRequest request;
    @MockBean
    JwtProvider jwtProvider;
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
    void getUserById() throws Exception {
        int userId = 1;
        User userExpect = UserHibernate.builder().userId(userId).addressId(10).build();
        Mockito.when(userService.getUserById(1)).thenReturn(userExpect);
        UserResponse userResponseExpect = UserResponse.builder()
                .status(ResponseStatus.builder().message("Returning the User By Id.")
                        .success(true)
                        .build()).user(userExpect).build();
        Gson gson = new Gson();
        String json = gson.toJson(userResponseExpect);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/"+userId)
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(json));
        Mockito.verify(userService, Mockito.times(1)).getUserById(userId);
    }

    @Test
    void createNewUser() throws Exception {
          User newUser = UserHibernate.builder().email("email@email.com").addressId(10).build();
        User userExpect = UserHibernate.builder().userId(99).email("email@email.com").addressId(10).build();
        Mockito.when(userService.createNewUser(newUser)).thenReturn(userExpect);

        UserResponse userResponseExpect = UserResponse.builder()
                .status(ResponseStatus.builder().message("Created a new User.")
                        .success(true)
                        .build()).user(userExpect).build();
        Gson gson = new Gson();
        String json = gson.toJson(userResponseExpect);
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void deleteUserById() throws Exception {
        int userId = 90;
        User userExpect = UserHibernate.builder().userId(userId).email("email@email.com").addressId(10).build();
        Mockito.when(userService.deleteUserById(userId)).thenReturn(userExpect);
        UserResponse userResponseExpect = UserResponse.builder()
                .status(ResponseStatus.builder().message("Delete User success.")
                        .success(true)
                        .build()).user(userExpect).build();
        Gson gson = new Gson();
        String json = gson.toJson(userResponseExpect);
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/"+userId)
                .contentType(MediaType.APPLICATION_JSON).contentType(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(json));
        Mockito.verify(userService, Mockito.times(1)).deleteUserById(userId);
    }

    @Test
    void changeUserStatus() throws Exception {
        int userId = 90;
        boolean activate = false;
        User userExpect = UserHibernate.builder().userId(userId)
                .email("email@email.com").isActive(activate).addressId(10).build();
        Mockito.when(userService.changeUserStatus(userId, activate)).thenReturn(userExpect);
        UserResponse userResponseExpect = UserResponse.builder()
                .status(ResponseStatus.builder().message("User Statue changed success.")
                        .success(true)
                        .build()).user(userExpect).build();
        Gson gson = new Gson();
        String json = gson.toJson(userResponseExpect);
        mockMvc.perform(MockMvcRequestBuilders
                .patch("/user/"+userId+"/status?activate="+activate)
                .contentType(MediaType.APPLICATION_JSON).contentType(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(json));
        Mockito.verify(userService, Mockito.times(1)).changeUserStatus(userId, activate);
    }

    @Test
    void deleteUserById_throwException() throws Exception {
        int userId = -1;
        User userExpect = UserHibernate.builder().userId(userId).email("email@email.com").addressId(10).build();
        Mockito.when(userService.deleteUserById(userId)).thenReturn(null);
        UserResponse userResponseExpect = UserResponse.builder()
                .status(ResponseStatus.builder().message("Some thing wrong!")
                        .success(false)
                        .build()).user(userExpect).build();
        Gson gson = new Gson();
        String json = gson.toJson(userResponseExpect);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/user/"+userId)
                        .contentType(MediaType.APPLICATION_JSON).contentType(json)).andReturn();
        Mockito.verify(userService, Mockito.times(1)).deleteUserById(userId);
    }
    @Test
    void changeUserStatus_throwException() throws Exception {
        int userId = 90;
        boolean activate = false;
        User userExpect = UserHibernate.builder().userId(userId).email("email@email.com").addressId(10).build();
        Mockito.when(userService.changeUserStatus(userId, activate)).thenReturn(null);
        UserResponse userResponseExpect = UserResponse.builder()
                .status(ResponseStatus.builder().message("Some thing wrong!")
                        .success(false)
                        .build()).user(userExpect).build();
        Gson gson = new Gson();
        String json = gson.toJson(userResponseExpect);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.patch("/user/"+userId+"/status?activate="+activate)
                .contentType(MediaType.APPLICATION_JSON).contentType(json)).andReturn();
        Mockito.verify(userService, Mockito.times(1)).changeUserStatus(userId, activate);

    }
}