package com.beaconfire.pp_webservice_restful.service;

import com.beaconfire.pp_webservice_restful.dao.QuizDao;
import com.beaconfire.pp_webservice_restful.dao.hibernate.QuizDaoHibernateImpl;
import com.beaconfire.pp_webservice_restful.domain.Quiz;
import com.beaconfire.pp_webservice_restful.domain.User;
import com.beaconfire.pp_webservice_restful.domain.hibernate.QuizHibernate;
import com.beaconfire.pp_webservice_restful.exception.QuizNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class QuizServiceTest {


    @Mock
    QuizDao quizDao;

    @InjectMocks
    QuizService quizService;
    @Spy
    List<Quiz> quizzesSpy = new ArrayList<>();

    @Test
    void getAllQuizzes() {
        quizzesSpy.add(QuizHibernate.builder().quizId(-1).build());
        Mockito.when(quizDao.getAllQuizzes()).thenReturn(quizzesSpy);
        assertEquals(quizzesSpy, quizService.getAllQuizzes());
        Mockito.verify(quizDao, Mockito.times(1)).getAllQuizzes();
    }

    @Test
    void getAllQuizzesByUserId() throws QuizNotFoundException {
        Quiz quiz = QuizHibernate.builder().quizId(1).quizName("Test Name").build();
        quizzesSpy.add(quiz);
        Mockito.when(quizDao.getAllQuizzesByUserId(1)).thenReturn(quizzesSpy);
        assertEquals(quizzesSpy, quizService.getAllQuizzesByUserId(1));
        Mockito.verify(quizDao, Mockito.times(1)).getAllQuizzesByUserId(1);
    }
}