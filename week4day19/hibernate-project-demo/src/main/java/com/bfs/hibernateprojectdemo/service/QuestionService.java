package com.bfs.hibernateprojectdemo.service;

import com.bfs.hibernateprojectdemo.dao.QuestionDao;
import com.bfs.hibernateprojectdemo.dao.hibernate.QuestionDaoHibernateImpl;
import com.bfs.hibernateprojectdemo.domain.Question;
import com.bfs.hibernateprojectdemo.domain.hibernate.QuestionHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionService {
    private QuestionDao questionJdbcDao;
    private QuestionDao questionHibernateDao;

    @Autowired
    public void setQuestionJdbcDao(@Qualifier("questionDaoJdbcImpl") QuestionDao questionJdbcDao) {
        this.questionJdbcDao = questionJdbcDao;
    }

    @Autowired
    @Qualifier("questionDaoHibernateImpl")
    public void setQuestionHibernateDao( QuestionDao questionHibernateDao) {
        this.questionHibernateDao = questionHibernateDao;
    }

    @Transactional
    public List<Question> getAllQuestions() {
        return questionHibernateDao.getAllQuestions();
    }

    @Transactional
    public Question getQuestionById(int id) { return questionJdbcDao.getQuestionById(id); }

    @Transactional
    public void addQuestion(Question... questions) {
        for (Question q : questions) {
            questionHibernateDao.addQuestion(q);
        }
    }


}
