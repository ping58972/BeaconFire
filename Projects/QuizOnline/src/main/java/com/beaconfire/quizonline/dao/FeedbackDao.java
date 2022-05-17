package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.domain.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class FeedbackDao {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    FeedbackRowMapper feedbackRowMapper;
    @Autowired
    public FeedbackDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, FeedbackRowMapper feedbackRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.feedbackRowMapper = feedbackRowMapper;
    }
    public List<Feedback> getAllFeedback(){
        return jdbcTemplate.query("SELECT * FROM Feedback", feedbackRowMapper);
    }
    public Optional<Feedback> getFeedbackById(int id){
        return jdbcTemplate.query("SELECT * FROM Feedback WHERE feedback_id=?",
                feedbackRowMapper, id).stream().findFirst();
    }
    public int createNewFeedback(int userId, String message, int rating, Timestamp feedbackTime){
        String query = "INSERT INTO Feedback(user_id, message, rating, feedback_time) VALUES(?,?,?,?)";
        return jdbcTemplate.update(query, userId, message, rating, feedbackTime);
    }
    public int updateFeedback(int id,  String message, int rating){
        String query = "UPDATE Feedback SET message=?, rating=?, feedback_time=? WHERE feedback_id=?";
        return jdbcTemplate.update(query, message, rating, new Timestamp(System.currentTimeMillis()), id);
    }
    public int deleteFeedbackById(int id){
        return jdbcTemplate.update("DELETE FROM Feedback WHERE feedback_id=?", id);
    }
}
