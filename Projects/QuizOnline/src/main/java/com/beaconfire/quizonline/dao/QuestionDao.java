package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.domain.Category;
import com.beaconfire.quizonline.domain.Choice;
import com.beaconfire.quizonline.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class QuestionDao {
    JdbcTemplate jdbcTemplate;
    QuestionRowMapper questionRowMapper;
    ChoiceRowMapper choiceRowMapper;
    CategoryDao categoryDao;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public QuestionDao(JdbcTemplate jdbcTemplate, QuestionRowMapper questionRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                       ChoiceRowMapper choiceRowMapper, CategoryDao categoryDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.questionRowMapper = questionRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.choiceRowMapper = choiceRowMapper;
        this.categoryDao = categoryDao;
    }

    public List<Question> getAllQuestion() {
        List<Question> questions = jdbcTemplate.query("SELECT * FROM Question", questionRowMapper);
        List<Choice> choices = jdbcTemplate.query("SELECT * FROM Choice", choiceRowMapper);
        List<Category> categories = categoryDao.getAllCategory();
        for (Question q : questions) {
            Map<Integer, Choice> map = new HashMap<>();
            for (Choice c : choices) {
                if (q.getQuestionId() == c.getQuestionId()) {
                    map.put(c.getChoiceId(), c);
                }
            }
            for (Category c : categories) {
                if (c.getCategoryId() == q.getCategoryId()) {
                    q.setCategoryName(c.getName());
                }
            }
            q.setChoiceMap(map);
        }
        return questions;
    }

    public List<Question> getAllQuestionByCategoryId(int id) {
        List<Question> questions = getAllQuestion();
        return questions.stream().filter(q -> q.getCategoryId() == id && q.isActive()).collect(Collectors.toList());
    }

    public List<Question> getAllQuestionByCategoryIdAndType(int id, String type) {
        List<Question> questions = getAllQuestionByCategoryId(id);
        return questions.stream().filter(q -> q.getType() == type).collect(Collectors.toList());
    }

    public Optional<Question> getQuestionById(int id) {
        List<Question> questions = jdbcTemplate.query(
                "SELECT * FROM Question WHERE question_id=?", questionRowMapper, id);
        return questions.stream().map(q -> {
            Map<Integer, Choice> choices = jdbcTemplate.query(
                            "SELECT * FROM Choice WHERE question_id=?", choiceRowMapper, q.getQuestionId())
                    .stream().collect(Collectors.toMap(Choice::getChoiceId, Function.identity()));
            q.setChoiceMap(choices);
            return q;
        }).findFirst();
    }

    public int createNewQuestion(int categoryId, String questDesc, String type,
                                 String correctAnswer, String... choiceDescrs) {
        String query = "INSERT INTO Question(category_id, description, type) VALUES(?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, categoryId);
            ps.setString(2, questDesc);
            ps.setString(3, type);
            return ps;
        }, keyHolder);
        int questId = keyHolder.getKey().intValue();
        String choiceQuery = "INSERT INTO Choice(question_id, choice_description, is_correct)" +
                " VALUES(?,?,?)";
        if (type.equals("SHORT_ANSWER")) {
            return jdbcTemplate.update(choiceQuery, questId, correctAnswer, true);
        }
        jdbcTemplate.update(choiceQuery, questId, correctAnswer, true);
        for (String descr : choiceDescrs) {
            jdbcTemplate.update(choiceQuery, questId, descr, false);
        }
        return keyHolder.getKey().intValue();
    }

    public int changeActiveById(int id) {
        Optional<Question> q = getQuestionById(id);
        String query = "UPDATE Question SET is_active=? WHERE question_id=?";
        Question question = q.orElse(new Question());
        return jdbcTemplate.update(query, !question.isActive(), id);
    }

    public int deleteQuestionById(int id) {
        return jdbcTemplate.update("DELETE FROM Question WHERE question_id = ?", id);
    }
}
