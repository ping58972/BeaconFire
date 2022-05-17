package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.domain.Question;
import com.beaconfire.quizonline.domain.Quiz;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuizRowMapper implements RowMapper<Quiz> {

    @Override
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz quiz = new Quiz();
        quiz.setQuizId(rs.getInt("quiz_id"));
        quiz.setUserId(rs.getInt("user_id"));
        quiz.setCategoryId(rs.getInt("category_id"));
        quiz.setStartTime(rs.getTimestamp("start_time"));
        quiz.setEndTime(rs.getTimestamp("end_time"));
        quiz.setQuizName(rs.getString("quiz_name"));
        return quiz;
    }
}
