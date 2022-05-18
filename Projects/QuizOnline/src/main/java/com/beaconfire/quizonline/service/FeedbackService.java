package com.beaconfire.quizonline.service;

import com.beaconfire.quizonline.dao.FeedbackDao;
import com.beaconfire.quizonline.domain.Feedback;
import com.beaconfire.quizonline.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackDao feedbackDao;

    @Autowired
    public FeedbackService(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }

    public List<Feedback> getAllFeedback() {
        return feedbackDao.getAllFeedback();
    }

    public boolean createNewFeedback(Feedback fb) {
        return 1 == feedbackDao.createNewFeedback(fb.getUserId(),
                fb.getMessage(), fb.getRating(), fb.getFeedbackTime());
    }
}
