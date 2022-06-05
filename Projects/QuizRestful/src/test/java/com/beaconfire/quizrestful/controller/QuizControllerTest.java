package com.beaconfire.quizrestful.controller;

import com.beaconfire.quizrestful.domain.AllQuizResponse;
import com.beaconfire.quizrestful.domain.Quiz;
import com.beaconfire.quizrestful.domain.common.ResponseStatus;
import com.beaconfire.quizrestful.domain.hibernate.QuizHibernate;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import com.beaconfire.quizrestful.security.JwtProvider;
import com.beaconfire.quizrestful.service.QuizService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(controllers = QuizController.class)
class QuizControllerTest {

    @MockBean
    QuizService quizService;
    @Mock
    HttpServletRequest request;
    @MockBean
    JwtProvider jwtProvider;

    @Spy
    private List<Quiz> quizzesSpy = new ArrayList<>();

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;



    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//
//    @Test
//    void getAllQuizzes() throws Exception {
//        Quiz QuizExpect = QuizHibernate.builder().userId(1).quizId(10).build();
//        quizzesSpy.add(QuizExpect);
//        Mockito.when(quizService.getAllQuizzes()).thenReturn(quizzesSpy);
//        AllQuizResponse allQuizResponse = AllQuizResponse.builder()
//                .status(ResponseStatus.builder().success(true).message("Returning all Quizzes.").build())
//                .quizzes(quizzesSpy).build();
//        Gson gson = new Gson();
//        String json = gson.toJson(allQuizResponse);
//        mockMvc.perform(MockMvcRequestBuilders.get("/quiz")
//                        .contentType(MediaType.APPLICATION_JSON).content(json))
//                .andExpect(MockMvcResultMatchers.status().isOk()
//                )
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.content().json(json))
//        ;
//        Mockito.verify(quizService, Mockito.times(1)).getAllQuizzes();
//    }
//
//    @Test
//    void getAllQuizzesByUserId() throws Exception {
//        int userId = 99;
//        QuizHibernate QuizExpect = QuizHibernate.builder().userId(userId).quizId(10).build();
//        quizzesSpy.add(QuizExpect);
//        Mockito.when(quizService.getAllQuizzesByUserId(userId)).thenReturn(quizzesSpy);
//        AllQuizResponse allQuizResponse = AllQuizResponse.builder()
//                .status(ResponseStatus.builder().success(true).message("Returning all Quizzes by User Id.").build())
//                .quizzes(quizzesSpy).build();
//        Gson gson = new Gson();
//        String json = gson.toJson(allQuizResponse);
//        mockMvc.perform(MockMvcRequestBuilders.get("/quiz/user/"+ userId)
//                        .contentType(MediaType.APPLICATION_JSON).content(json))
//                .andExpect(MockMvcResultMatchers.status().isOk()
//                )
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.content().json(json))
//        ;
//        Mockito.verify(quizService, Mockito.times(1))
//                .getAllQuizzesByUserId(userId);
//    }
//    @Test
//    void getAllQuizzesByUserId_shouldThrowException() throws Exception {
//        int userId = -1;
//        QuizHibernate QuizExpect = QuizHibernate.builder().userId(userId).quizId(10).build();
//        quizzesSpy.add(QuizExpect);
//        Mockito.when(quizService.getAllQuizzesByUserId(userId)).thenThrow(QuizNotFoundException.class);
//        AllQuizResponse allQuizResponse = AllQuizResponse.builder()
//                .status(ResponseStatus.builder().success(true).message("Returning all Quizzes by User Id.").build())
//                .quizzes(quizzesSpy).build();
//        Gson gson = new Gson();
//        String json = gson.toJson(allQuizResponse);
//        mockMvc.perform(MockMvcRequestBuilders.get("/quiz/user/"+ userId));
////                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
//        Mockito.verify(quizService, Mockito.times(1))
//                .getAllQuizzesByUserId(userId);
//    }
}