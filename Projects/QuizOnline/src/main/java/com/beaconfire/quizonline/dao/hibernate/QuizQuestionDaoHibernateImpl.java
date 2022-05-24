package com.beaconfire.quizonline.dao.hibernate;

import com.beaconfire.quizonline.dao.QuizDao;
import com.beaconfire.quizonline.dao.QuizQuestionDao;
import com.beaconfire.quizonline.domain.QuizQuestion;
import com.beaconfire.quizonline.domain.hibernate.QuizHibernate;
import com.beaconfire.quizonline.domain.hibernate.QuizQuestionHibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("quizQuestionDaoHibernateImpl")
@Transactional
public class QuizQuestionDaoHibernateImpl extends AbstractHibernateDao<QuizQuestionHibernate> implements QuizQuestionDao {

    @Override
    public List<QuizQuestion> getAllQuizQuestion() {
        return null;
    }

    @Override
    public QuizQuestion getQuizQuestionById(int id) {
        return null;
    }

    @Override
    public QuizQuestion getQuizQuestionByQuizIdAndQuestionId(int quizId, int questId) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public int deleteByQuizIdAndQuestionId(int quizId, int questId) {
        return 0;
    }

    @Override
    public int createNewQuizQuestion(int quizId, int questId, int userChoiceId, String userShortAnswer, int orderNum, boolean isMarked) {
        return 0;
    }

    @Override
    public int updateQuizQuestionById(int qqId, int userChoiceId, String userShortAnswer, int orderNum, boolean isMarked) {
        return 0;
    }

    @Override
    public int updateQuizQuestionByQuizIdAndQuestionId(int quizId, int questId, int userChoiceId, String userShortAnswer, int orderNum, boolean isMarked) {
        return 0;
    }
}
