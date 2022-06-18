package com.beaconfire.quizonline.dao.hibernate;

import com.beaconfire.quizonline.dao.QuestionDao;
import com.beaconfire.quizonline.dao.QuizDao;
import com.beaconfire.quizonline.domain.Quiz;
import com.beaconfire.quizonline.domain.hibernate.QuizHibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository("quizDaoHibernateImpl")
@Transactional
public class QuizDaoHibernateImpl extends AbstractHibernateDao<QuizHibernate> implements QuizDao {

    @Override
    public List<Quiz> getAllQuiz() {
        return null;
    }

    @Override
    public Optional<Quiz> getQuizById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Quiz> getQuizByUserId(int id) {
        return null;
    }

    @Override
    public List<Quiz> getQuizByCategoryId(int id) {
        return null;
    }

    @Override
    public int createNewQuizByCategoryForUser(int userId, int categoryId) {
        return 0;
    }

    @Override
    public int setEndTimeById(int quizId) {
        return 0;
    }

    @Override
    public int deleteQuizById(int id) {
        return 0;
    }
}
