package com.beaconfire.pp_webservice_restful.service;

import com.beaconfire.pp_webservice_restful.dao.QuizDao;
import com.beaconfire.pp_webservice_restful.domain.Quiz;
import com.beaconfire.pp_webservice_restful.exception.QuizNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private QuizDao quizDaoHibernate;
    @Autowired
    @Qualifier("quizDaoHibernateImpl")
    public void setQuizDaoHibernate(QuizDao quizDaoHibernate) {
        this.quizDaoHibernate = quizDaoHibernate;
    }

    public List<Quiz> getAllQuizzes() throws QuizNotFoundException {
        return quizDaoHibernate.getAllQuizzes();
    }

    public List<Quiz> getAllQuizzesByUserId(int userId) throws QuizNotFoundException {
        return quizDaoHibernate.getAllQuizzesByUserId(userId);
    }
}
