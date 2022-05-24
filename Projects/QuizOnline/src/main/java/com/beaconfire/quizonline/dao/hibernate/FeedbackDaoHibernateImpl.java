package com.beaconfire.quizonline.dao.hibernate;


import com.beaconfire.quizonline.dao.FeedbackDao;

import com.beaconfire.quizonline.domain.Contact;
import com.beaconfire.quizonline.domain.Feedback;
import com.beaconfire.quizonline.domain.hibernate.ContactHibernate;
import com.beaconfire.quizonline.domain.hibernate.FeedbackHibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository("feedbackDaoHibernateImpl")
@Transactional
public class FeedbackDaoHibernateImpl extends AbstractHibernateDao<FeedbackHibernate> implements FeedbackDao {

    @Override
    public List<Feedback> getAllFeedback() {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM FeedbackHibernate ");
        List<Feedback> qhList = query.list();
        return qhList;
    }

    @Override
    public Optional<Feedback> getFeedbackById(int id) {
        FeedbackHibernate feed = findById(id);
        return Optional.of(feed);
    }

    @Override
    public int createNewFeedback(int userId, String message, int rating, Timestamp feedbackTime) {
        FeedbackHibernate feed = new FeedbackHibernate();
        feed.setUserId(userId);
        feed.setMessage(message);
        feed.setRating(rating);
        feed.setFeedbackTime(feedbackTime);
        return (int) getCurrentSession().save(feed);
    }

    @Override
    public int updateFeedback(int id, String message, int rating) {
        FeedbackHibernate feed = new FeedbackHibernate();
        feed.setMessage(message);
        feed.setRating(rating);
        getCurrentSession().saveOrUpdate(feed);
        return 1;
    }

    @Override
    public int deleteFeedbackById(int id) {
        return 0;
    }
}
