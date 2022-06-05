package com.beaconfire.quizrestful.dao.hibernate;

import com.beaconfire.quizrestful.dao.QuizDao;
import com.beaconfire.quizrestful.domain.Quiz;
import com.beaconfire.quizrestful.domain.QuizQuestion;
import com.beaconfire.quizrestful.domain.hibernate.QuizHibernate;
import com.beaconfire.quizrestful.domain.hibernate.UserHibernate;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import com.beaconfire.quizrestful.exception.UserNotFoundException;
import org.hibernate.Transaction;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository("quizDaoHibernateImpl")

public class QuizDaoHibernateImpl extends AbstractHibernateDao<QuizHibernate> implements QuizDao {
    public QuizDaoHibernateImpl() {
        setClazz(QuizHibernate.class);
    }

    @Override
    @Cacheable("allQuizzes")
    public List<Quiz> getAllQuizzes() {
        return getAll().stream().map(q->(QuizHibernate)q).collect(Collectors.toList());
    }

    @Override
    @Cacheable("allQuizzesByUserId")
    public List<Quiz>  getAllQuizzesByUserId(int userId) throws QuizNotFoundException {
        Query query = getCurrentSession().createQuery("FROM QuizHibernate q WHERE q.userId = :userId");
        query.setParameter("userId", userId);
        List<Quiz> quizzes = query.getResultList();
        if(quizzes.size() == 0){
            throw new QuizNotFoundException("No any Quiz found for User Id " + userId);
        }
        return quizzes;
    }
    @Override
    @Transactional
    @Cacheable("allQuizzesByUserId")
    public List<Quiz>  getAllQuizzesByUserId_trans(int userId) throws QuizNotFoundException {
        Query query = getCurrentSession().createQuery("FROM QuizHibernate q WHERE q.userId = :userId");
        query.setParameter("userId", userId);
        List<Quiz> quizzes = query.getResultList();
        if(quizzes.size() == 0){
            throw new QuizNotFoundException("No any Quiz found for User Id " + userId);
        }
        return quizzes;
    }

    @Override
    @Transactional
    @Cacheable("allQuizzesByUserId")
    public List<Quiz> getAllQuizzesByUserIdAsync(int userId) throws QuizNotFoundException {
        Query query = getCurrentSession().createQuery("FROM QuizHibernate q WHERE q.userId = :userId");
        query.setParameter("userId", userId);
        List<Quiz> quizzes = query.getResultList();
        if(quizzes.size() == 0){
            throw new QuizNotFoundException("No any Quiz found for User Id " + userId);
        }
        return quizzes;
//
//        Transaction transaction = null;
//        List<Quiz> quizzes = null;
//        try {
//            transaction = getCurrentSession().beginTransaction();
//            Query query =  getCurrentSession().createQuery("FROM QuizHibernate q WHERE q.userId = :userId");
//            query.setParameter("userId", userId);
//            quizzes = query.getResultList();
//            transaction.commit();
////            if(quizzes.size() == 0){
////                throw new QuizNotFoundException("User Not found to delete.");
////            }
//
//        } catch (Exception e){
//            e.printStackTrace();
//            if(transaction != null){
//                transaction.rollback();
//            }
//            throw new QuizNotFoundException("Uh! something wrong!");
//        }
//        return quizzes;
    }

    @Override
    @Cacheable("allAnswerByQuizId")
    public List<QuizQuestion> getAllAnswerByQuizId(int quizId) throws QuizNotFoundException {
        Query query = getCurrentSession().createQuery("FROM QuizQuestionHibernate qq WHERE qq.quizId = :quizId");
        query.setParameter("quizId", quizId);
        List<QuizQuestion> qqs = query.getResultList();
        if(qqs.size() == 0){
            throw new QuizNotFoundException("No any Answer found for Quiz Id " + quizId);
        }
        return qqs;
    }
}
