package com.beaconfire.pp_webservice_restful.dao.hibernate;

import com.beaconfire.pp_webservice_restful.dao.QuizDao;
import com.beaconfire.pp_webservice_restful.domain.AllQuizResponse;
import com.beaconfire.pp_webservice_restful.domain.Quiz;
import com.beaconfire.pp_webservice_restful.domain.hibernate.QuizHibernate;

import java.util.List;

public class QuizDaoHibernateImpl extends AbstractHibernateDao<QuizHibernate> implements QuizDao {
    @Override
    public List<Quiz> getAllQuizzes() {
        return null;
    }

    @Override
    public List<Quiz>  getAllQuizzesByUserId(int userId) {
        return null;
    }
}
