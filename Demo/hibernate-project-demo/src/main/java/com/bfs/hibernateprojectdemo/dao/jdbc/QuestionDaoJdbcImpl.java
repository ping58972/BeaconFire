package com.bfs.hibernateprojectdemo.dao.jdbc;

import com.bfs.hibernateprojectdemo.dao.QuestionDao;
import com.bfs.hibernateprojectdemo.dao.rowmapper.QuestionRowMapper;
import com.bfs.hibernateprojectdemo.domain.Question;
import com.bfs.hibernateprojectdemo.domain.jdbc.QuestionJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionDaoJdbcImpl")
public class QuestionDaoJdbcImpl implements QuestionDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setQuestionJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Question getQuestionById(int id) {
        String sql = "SELECT * FROM Question where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new QuestionRowMapper());
    }

    @Override
    public List<Question> getAllQuestions() {
        String sql = "SELECT * FROM Question";
        return jdbcTemplate.query(sql, new Object[]{}, new QuestionRowMapper());
    }

    @Override
    public void addQuestion(Question question) {
        String sql = "insert into Question (description, is_active) values (?, ?)";
        jdbcTemplate.update(sql,
                question.getDescription(),
                question.isActive());
    }

}
