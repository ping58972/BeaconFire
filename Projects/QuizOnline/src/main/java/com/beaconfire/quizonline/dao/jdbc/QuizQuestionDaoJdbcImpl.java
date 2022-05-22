package com.beaconfire.quizonline.dao.jdbc;

import com.beaconfire.quizonline.dao.QuestionDao;
import com.beaconfire.quizonline.dao.QuizQuestionDao;
import com.beaconfire.quizonline.dao.jdbc.rowmapper.QuestionRowMapper;
import com.beaconfire.quizonline.dao.jdbc.rowmapper.QuizQuestionRowMapper;
import com.beaconfire.quizonline.domain.Question;
import com.beaconfire.quizonline.domain.QuizQuestion;
import com.beaconfire.quizonline.domain.jdbc.QuestionJdbc;
import com.beaconfire.quizonline.domain.jdbc.QuizQuestionJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

@Repository("quizQuestionDaoJdbcImpl")
public class QuizQuestionDaoJdbcImpl implements QuizQuestionDao {

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    QuizQuestionRowMapper quizQuestionRowMapper;
    QuestionRowMapper questionRowMapper;
    QuestionDao questionDao;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Autowired
    public void setQuizQuestionRowMapper(QuizQuestionRowMapper quizQuestionRowMapper) {
        this.quizQuestionRowMapper = quizQuestionRowMapper;
    }

    @Autowired
    public void setQuestionRowMapper(QuestionRowMapper questionRowMapper) {
        this.questionRowMapper = questionRowMapper;
    }

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<QuizQuestion> getAllQuizQuestion() {
        return jdbcTemplate.query("SELECT * FROM Quiz_Question",
                quizQuestionRowMapper).stream().map(qq -> {
            Question q = questionDao.getQuestionById(qq.getQuestionId())
                    .orElse(new QuestionJdbc());
            qq.setQuestion(q);
            return qq;
        }).collect(Collectors.toList());
    }

    public QuizQuestion getQuizQuestionById(int id) {
        return jdbcTemplate.query(
                        "SELECT * FROM Quiz_Question WHERE qq_id=?",
                        quizQuestionRowMapper, id).stream().map(qq -> {
                    Question q = questionDao.getQuestionById(qq.getQuestionId())
                            .orElse(new QuestionJdbc());
                    qq.setQuestion(q);
                    return qq;
                }).findFirst()
                .orElse(new QuizQuestionJdbc());
    }

    public QuizQuestion getQuizQuestionByQuizIdAndQuestionId(int quizId, int questId) {
        return jdbcTemplate.query(
                        "SELECT * FROM Quiz_Question WHERE quiz_id=? AND question_id=?",
                        quizQuestionRowMapper, quizId, questId).stream().map(qq -> {
                    Question q = questionDao.getQuestionById(qq.getQuestionId())
                            .orElse(new QuestionJdbc());
                    qq.setQuestion(q);
                    return qq;
                }).findFirst()
                .orElse(new QuizQuestionJdbc());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM Quiz_Question WHERE qq_id=?", id);
    }

    public int deleteByQuizIdAndQuestionId(int quizId, int questId) {
        return jdbcTemplate.update(
                "DELETE FROM Quiz_Question WHERE quiz_id=? AND question_id=?", quizId, questId);
    }

    public int createNewQuizQuestion(int quizId, int questId, int userChoiceId,
                                     String userShortAnswer, int orderNum, boolean isMarked) {
        String query = "INSERT INTO Quiz_Question(quiz_id, question_id, user_choice_id," +
                " user_short_answer, order_num, is_marked) VALUES(?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, quizId);
            ps.setInt(2, questId);
            ps.setInt(3, userChoiceId);
            ps.setString(4, userShortAnswer);
            ps.setInt(5, orderNum);
            ps.setBoolean(6, isMarked);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public int updateQuizQuestionById(int qqId, int userChoiceId, String userShortAnswer,
                                      int orderNum, boolean isMarked) {
        String query = "UPDATE Quiz_Question SET user_choice_id=?, user_short_answer=?, " +
                "order_num=?, is_marked=? WHERE qq_id=?";
        return jdbcTemplate.update(query, userChoiceId, userShortAnswer, orderNum, isMarked, qqId);
    }

    public int updateQuizQuestionByQuizIdAndQuestionId(int quizId, int questId, int userChoiceId, String userShortAnswer,
                                                       int orderNum, boolean isMarked) {
        String query = "UPDATE Quiz_Question SET user_choice_id=?, user_short_answer=?, " +
                "order_num=?, is_marked=? WHERE quiz_id=? AND question_id=?";
        return jdbcTemplate.update(query, userChoiceId, userChoiceId,
                orderNum, isMarked, quizId, questId);
    }
}
