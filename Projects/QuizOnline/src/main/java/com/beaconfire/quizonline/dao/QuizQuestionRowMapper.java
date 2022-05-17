package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.domain.QuizQuestion;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuizQuestionRowMapper implements RowMapper<QuizQuestion> {
    @Override
    public QuizQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuizQuestion qq = new QuizQuestion();
        qq.setQqId(rs.getInt("qq_id"));
        qq.setQuizId(rs.getInt("quiz_id"));
        qq.setQuestionId(rs.getInt("question_id"));
        qq.setUserChoiceId(rs.getInt("user_choice_id"));
        qq.setUserShortAnswer(rs.getString("user_short_answer"));
        qq.setOrderNum(rs.getInt("order_num"));
        qq.setMarked(rs.getBoolean("is_marked"));
        return qq;
    }
}
