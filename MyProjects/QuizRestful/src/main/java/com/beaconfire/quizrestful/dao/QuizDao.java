package com.beaconfire.quizrestful.dao;

import com.beaconfire.quizrestful.domain.*;
import com.beaconfire.quizrestful.domain.hibernate.QuizHibernate;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;

import java.util.List;

public interface QuizDao {

    List<Quiz> getAllQuizzes();
    List<Quiz>  getAllQuizzesByUserId(int userId) throws QuizNotFoundException;
    List<Quiz>  getAllQuizzesByUserIdAsync(int userId) throws QuizNotFoundException;
    List<Quiz>  getAllQuizzesByUserId_trans(int userId) throws QuizNotFoundException;
    List<QuizQuestion> getAllAnswerByQuizId(int quizId) throws QuizNotFoundException;

}
