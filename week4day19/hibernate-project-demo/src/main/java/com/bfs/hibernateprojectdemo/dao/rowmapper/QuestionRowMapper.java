package com.bfs.hibernateprojectdemo.dao.rowmapper;

import com.bfs.hibernateprojectdemo.domain.Question;
import com.bfs.hibernateprojectdemo.domain.jdbc.QuestionJdbc;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet res, int i) throws SQLException {
        Question question = new QuestionJdbc();
        question.setId(res.getInt("id"));
        question.setDescription(res.getString("description"));
        question.setActive(res.getBoolean("is_active"));
        return question;
    }
}