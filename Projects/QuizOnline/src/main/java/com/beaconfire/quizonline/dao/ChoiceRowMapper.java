package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.domain.Choice;
import com.beaconfire.quizonline.domain.Question;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ChoiceRowMapper implements RowMapper<Choice> {
    @Override
    public Choice mapRow(ResultSet rs, int rowNum) throws SQLException {
        Choice choice = new Choice();
        choice.setChoiceId(rs.getInt("choice_id"));
        choice.setQuestionId(rs.getInt("question_id"));
        choice.setChoiceDesription(rs.getString("choice_description"));
        choice.setCorrect(rs.getBoolean("is_correct"));
        return choice;
    }
}
