package com.beaconfire.quizonline.dao.hibernate;

import com.beaconfire.quizonline.dao.QuestionDao;
import com.beaconfire.quizonline.domain.Question;
import com.beaconfire.quizonline.domain.hibernate.QuestionHibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository("questionDaoHibernateImpl")
@Transactional
public class QuestionDaoHibernateImpl extends AbstractHibernateDao<QuestionHibernate> implements QuestionDao {

    @Override
    public List<Question> getAllQuestion() {
        return null;
    }

    @Override
    public List<Question> getAllQuestionByCategoryId(int id) {
        return null;
    }

    @Override
    public List<Question> getAllQuestionByCategoryIdAndType(int id, String type) {
        return null;
    }

    @Override
    public Optional<Question> getQuestionById(int id) {
        return Optional.empty();
    }

    @Override
    public int createNewQuestion(int categoryId, String questDesc, String type, String correctAnswer, String... choiceDescrs) {
        return 0;
    }

    @Override
    public int changeActiveById(int id) {
        return 0;
    }

    @Override
    public int deleteQuestionById(int id) {
        return 0;
    }

    @Override
    public int updateQuestion(int questionId, int categoryId, String description, String type, boolean active, int correctAnswerId, String correctAnswer, int choiceId1, String choice1, int choiceId2, String choice2, int choiceId3, String choice3) {
        return 0;
    }
}
