package com.bfs.hibernateprojectdemo.dao.hibernate;

import com.bfs.hibernateprojectdemo.dao.AbstractHibernateDao;
import com.bfs.hibernateprojectdemo.dao.QuestionDao;
import com.bfs.hibernateprojectdemo.domain.Question;
import com.bfs.hibernateprojectdemo.domain.hibernate.QuestionHibernate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("questionDaoHibernateImpl")
public class QuestionDaoHibernateImpl extends AbstractHibernateDao<QuestionHibernate> implements QuestionDao {

    public QuestionDaoHibernateImpl() { setClazz(QuestionHibernate.class);}

    @Override
    public Question getQuestionById(int id) {
        return findById(id);
    }

    @Override
    public List<Question> getAllQuestions() {
        List<QuestionHibernate> lst = this.getAll();
        return lst.stream().map(q -> (Question) q).collect(Collectors.toList());
    }

    @Override
    public void addQuestion(Question question) { add((QuestionHibernate) question); }

}
