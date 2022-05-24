package com.beaconfire.quizonline.service;

import com.beaconfire.quizonline.dao.FeedbackDao;
import com.beaconfire.quizonline.domain.Feedback;
import com.beaconfire.quizonline.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private FeedbackDao feedbackDaoJdbc;
    private FeedbackDao feedbackDaoHibernate;

    @Autowired
    @Qualifier("feedbackDaoJdbcImpl")
    public void setFeedbackDaoJdbc(FeedbackDao feedbackDaoJdbc) {
        this.feedbackDaoJdbc = feedbackDaoJdbc;
    }

    @Autowired
    @Qualifier("feedbackDaoHibernateImpl")
    public void setFeedbackDaoHibernate(FeedbackDao feedbackDaoHibernate) {
        this.feedbackDaoHibernate = feedbackDaoHibernate;
    }

    public List<Feedback> getAllFeedback() {

//        return feedbackDaoJdbc.getAllFeedback();
        return feedbackDaoHibernate.getAllFeedback();
    }

    public boolean createNewFeedback(Feedback fb) {
//        return 1 == feedbackDaoJdbc.createNewFeedback(fb.getUserId(),
//                fb.getMessage(), fb.getRating(), fb.getFeedbackTime());
        return 0 < feedbackDaoHibernate.createNewFeedback(fb.getUserId(),
                fb.getMessage(), fb.getRating(), fb.getFeedbackTime());

    }
}
