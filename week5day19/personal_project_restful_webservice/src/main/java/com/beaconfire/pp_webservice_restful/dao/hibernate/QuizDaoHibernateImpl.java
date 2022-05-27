package com.beaconfire.pp_webservice_restful.dao.hibernate;

import com.beaconfire.pp_webservice_restful.dao.QuizDao;
import com.beaconfire.pp_webservice_restful.domain.Quiz;
import com.beaconfire.pp_webservice_restful.domain.hibernate.QuizHibernate;
import com.beaconfire.pp_webservice_restful.exception.QuizNotFoundException;
import com.beaconfire.pp_webservice_restful.exception.UserNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository("quizDaoHibernateImpl")
public class QuizDaoHibernateImpl extends AbstractHibernateDao<QuizHibernate> implements QuizDao {
    public QuizDaoHibernateImpl() {
        setClazz(QuizHibernate.class);
    }

    @Override
    public List<Quiz> getAllQuizzes() throws QuizNotFoundException {
        return getAll().stream().map(q->(QuizHibernate)q).collect(Collectors.toList());
    }

    @Override
    public List<Quiz>  getAllQuizzesByUserId(int userId) throws QuizNotFoundException {
        Query query = getCurrentSession().createQuery("FROM QuizHibernate q WHERE q.userId = :userId");
        query.setParameter("userId", userId);
        List<Quiz> quizzes = query.getResultList();
        if(quizzes.size() == 0){
            throw new QuizNotFoundException("No any Quiz found for User Id " + userId);
        }
        return quizzes;
    }
}
