package com.beaconfire.quizrestful.service;

import com.beaconfire.quizrestful.dao.QuizDao;
import com.beaconfire.quizrestful.domain.Quiz;
import com.beaconfire.quizrestful.domain.QuizQuestion;
import com.beaconfire.quizrestful.domain.hibernate.QuizHibernate;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class QuizService {
    private QuizDao quizDaoHibernate;
    @Autowired
    @Qualifier("quizDaoHibernateImpl")
    public void setQuizDaoHibernate(QuizDao quizDaoHibernate) {
        this.quizDaoHibernate = quizDaoHibernate;
    }

    public List<Quiz> getAllQuizzes() {
        return quizDaoHibernate.getAllQuizzes();
    }

    public List<Quiz> getAllQuizzesByUserId(int userId) throws QuizNotFoundException {
        return quizDaoHibernate.getAllQuizzesByUserId(userId);
    }
//    @Transactional
    public List<Quiz>  getAllQuizzesByUserId_trans(int userId) throws QuizNotFoundException {
        return quizDaoHibernate.getAllQuizzesByUserId_trans(userId);
    }
    @Async("taskExecutor")
    public CompletableFuture<List<Quiz>> getAllQuizzesByUserIdAsync(int userId) throws QuizNotFoundException {
        return CompletableFuture.completedFuture(quizDaoHibernate.getAllQuizzesByUserIdAsync(userId));
    }
    public List<QuizQuestion> getAllAnswerByQuizId(int quizId) throws QuizNotFoundException {
        return quizDaoHibernate.getAllAnswerByQuizId(quizId);
    }
}
