package com.beaconfire.quizonline.dao.jdbc;

import com.beaconfire.quizonline.dao.CategoryDao;
import com.beaconfire.quizonline.dao.QuestionDao;
import com.beaconfire.quizonline.dao.jdbc.rowmapper.ChoiceRowMapper;
import com.beaconfire.quizonline.dao.jdbc.rowmapper.QuestionRowMapper;
import com.beaconfire.quizonline.domain.Category;
import com.beaconfire.quizonline.domain.Choice;
import com.beaconfire.quizonline.domain.Question;
import com.beaconfire.quizonline.domain.jdbc.QuestionJdbc;
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

@Repository("questionDaoJdbcImpl")
public class QuestionDaoJdbcImpl implements QuestionDao {

    JdbcTemplate jdbcTemplate;
    QuestionRowMapper questionRowMapper;
    ChoiceRowMapper choiceRowMapper;
    CategoryDao categoryDao;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setQuestionRowMapper(QuestionRowMapper questionRowMapper) {
        this.questionRowMapper = questionRowMapper;
    }

    @Autowired
    public void setChoiceRowMapper(ChoiceRowMapper choiceRowMapper) {
        this.choiceRowMapper = choiceRowMapper;
    }

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
        Question question = q.orElse(new QuestionJdbc());
        return jdbcTemplate.update(query, !question.isActive(), id);
    }

    public int deleteQuestionById(int id) {
        return jdbcTemplate.update("DELETE FROM Question WHERE question_id = ?", id);
    }

    public int updateQuestion(int questionId, int categoryId, String description, String type, boolean active, int correctAnswerId, String correctAnswer, int choiceId1, String choice1, int choiceId2, String choice2, int choiceId3, String choice3) {
        String choiceQuery = "UPDATE Choice SET choice_description=? WHERE choice_id=?";
        jdbcTemplate.update(choiceQuery, correctAnswer, correctAnswerId);
        if (type.equals("MULTIPLE_CHOICE")) {
            jdbcTemplate.update(choiceQuery, choice1, choiceId1);
            jdbcTemplate.update(choiceQuery, choice2, choiceId2);
            jdbcTemplate.update(choiceQuery, choice3, choiceId3);
        }
        String questQuery = "UPDATE Question SET category_id=?, description=?, type=?, is_active=? WHERE question_id=?";
        return jdbcTemplate.update(questQuery, categoryId, description, type, active, questionId);
    }
}
