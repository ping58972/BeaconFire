package com.beaconfire.quizonline.dao.jdbc.rowmapper;

import com.beaconfire.quizonline.domain.Feedback;
import com.beaconfire.quizonline.domain.jdbc.FeedbackJdbc;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FeedbackRowMapper implements RowMapper<Feedback> {
    @Override
    public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
        Feedback feedback = new FeedbackJdbc();
        feedback.setFeedbackId(rs.getInt("feedback_id"));
        feedback.setUserId(rs.getInt("user_id"));
        feedback.setMessage(rs.getString("message"));
        feedback.setRating(rs.getInt("rating"));
        feedback.setFeedbackTime(rs.getTimestamp("feedback_time"));
        return feedback;
    }
}
