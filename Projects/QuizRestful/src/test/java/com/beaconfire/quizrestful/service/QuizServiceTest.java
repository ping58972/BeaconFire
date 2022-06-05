package com.beaconfire.quizrestful.service;

import com.beaconfire.quizrestful.dao.QuizDao;
import com.beaconfire.quizrestful.domain.Quiz;
import com.beaconfire.quizrestful.domain.hibernate.QuizHibernate;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

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
    @Test
    void getAllQuizzesByUserId_shouldThrowException() throws QuizNotFoundException {
        QuizNotFoundException quizNotFoundException = new QuizNotFoundException("No any Quiz found for User Id "+ -1);
        Mockito.when(quizDao.getAllQuizzesByUserId(-1)).thenThrow(quizNotFoundException);
        assertThrows(QuizNotFoundException.class, ()-> quizService.getAllQuizzesByUserId(-1));
        Mockito.verify(quizDao, Mockito.times(1)).getAllQuizzesByUserId(-1);
    }
}