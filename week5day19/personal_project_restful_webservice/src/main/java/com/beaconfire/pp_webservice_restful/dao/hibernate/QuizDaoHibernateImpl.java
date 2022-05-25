package com.beaconfire.pp_webservice_restful.dao.hibernate;

import com.beaconfire.pp_webservice_restful.dao.QuizDao;
import com.beaconfire.pp_webservice_restful.domain.Quiz;
import com.beaconfire.pp_webservice_restful.domain.hibernate.QuizHibernate;
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
    public List<Quiz> getAllQuizzes() {
        return getAll().stream().map(q->(QuizHibernate)q).collect(Collectors.toList());
    }

    @Override
    public List<Quiz>  getAllQuizzesByUserId(int userId) {
        Query query = getCurrentSession().createQuery("FROM QuizHibernate q WHERE q.userId = :userId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
