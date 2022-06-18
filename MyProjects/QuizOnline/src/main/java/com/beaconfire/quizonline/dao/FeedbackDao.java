package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.dao.jdbc.rowmapper.FeedbackRowMapper;
import com.beaconfire.quizonline.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


public interface FeedbackDao {
    List<Feedback> getAllFeedback();

    Optional<Feedback> getFeedbackById(int id);

    int createNewFeedback(int userId, String message, int rating, Timestamp feedbackTime);

    int updateFeedback(int id, String message, int rating);

    int deleteFeedbackById(int id);
}
