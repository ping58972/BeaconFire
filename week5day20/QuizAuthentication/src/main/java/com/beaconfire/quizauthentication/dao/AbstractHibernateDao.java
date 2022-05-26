package com.beaconfire.quizauthentication.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
public abstract class AbstractHibernateDao<T> {
    @Autowired
    protected SessionFactory sessionFactory;
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> getAll() {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(clazz);
        criteriaQuery.from(clazz);
        return session.createQuery(criteriaQuery).getResultList();
    }
    public T findById(int id) {
        return getCurrentSession().get(clazz, id);
    }
    public void add(T item) {
        getCurrentSession().save(item);
    }


}
