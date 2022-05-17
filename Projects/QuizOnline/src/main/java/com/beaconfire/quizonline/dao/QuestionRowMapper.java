package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.domain.Question;
import com.beaconfire.quizonline.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setQuestionId(rs.getInt("question_id"));
        question.setCategoryId(rs.getInt("category_id"));
        question.setActive(rs.getBoolean("is_active"));
        question.setDescription(rs.getString("description"));
        question.setType(rs.getString("type"));
        return question;
    }
}
