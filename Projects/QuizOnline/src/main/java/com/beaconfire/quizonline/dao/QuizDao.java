package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class QuizDao {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    QuizRowMapper quizRowMapper;
    QuizQuestionRowMapper quizQuestionRowMapper;
    QuestionRowMapper questionRowMapper;
    QuestionDao questionDao;
    UserDao userDao;
    CategoryDao categoryDao;
    QuizQuestionDao quizQuestionDao;
    @Autowired
    public QuizDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                   QuizRowMapper quizRowMapper, QuizQuestionRowMapper quizQuestionRowMapper,
                   QuestionRowMapper questionRowMapper, QuestionDao questionDao,
                   UserDao userDao, CategoryDao categoryDao, QuizQuestionDao quizQuestionDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.quizRowMapper = quizRowMapper;
        this.quizQuestionRowMapper = quizQuestionRowMapper;
        this.questionRowMapper = questionRowMapper;
        this.questionDao = questionDao;
        this.userDao = userDao;
        this.categoryDao = categoryDao;
        this.quizQuestionDao = quizQuestionDao;
    }
    public List<Quiz> getAllQuiz(){
        List<Quiz> quizzes = jdbcTemplate.query("SELECT * FROM Quiz", quizRowMapper);
        List<QuizQuestion> quizQuestions = quizQuestionDao.getAllQuizQuestion();
        return quizzes.stream().map(quiz ->{
            Map<Integer, QuizQuestion> map = quizQuestions.stream()
                    .filter(qq ->qq.getQuizId() == quiz.getQuizId())
                    .collect(Collectors.toMap(QuizQuestion::getQuestionId, Function.identity()));
            quiz.setQuizQuestionMap(map);
            User user = userDao.getUserById(quiz.getUserId());
            quiz.setUserName(user.getFirstName() + " "+ user.getLastName());
            Category category = categoryDao.getCategoryById(quiz.getCategoryId()).orElse(new Category());
            quiz.setCategoryName(category.getName());
            return quiz;
        }).collect(Collectors.toList());
    }
    public Optional<Quiz> getQuizById(int id){
        return getAllQuiz().stream().filter(quiz -> quiz.getQuizId() == id).findFirst();
    }
    public List<Quiz> getQuizByUserId(int id){
        return getAllQuiz().stream().filter(q->q.getUserId()==id).collect(Collectors.toList());
    }
    public List<Quiz> getQuizByCategoryId(int id){
        return getAllQuiz().stream().filter(q->q.getCategoryId()==id).collect(Collectors.toList());
    }
    public int createNewQuizByCategoryForUser(int userId, int categoryId){
        String quizQuery = "INSERT INTO Quiz(quiz_name, user_id, category_id, start_time, end_time)" +
                " VALUES(?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(quizQuery, Statement.RETURN_GENERATED_KEYS);
            User user = userDao.getUserById(userId);
            Category category = categoryDao.getCategoryById(categoryId).orElse(new Category());
            String quizName = user.getFirstName()+"."+user.getLastName()+"-"+ category.getName();
            ps.setString(1, quizName);
            ps.setInt(2, userId);
            ps.setInt(3, categoryId);
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(5, null); // new Timestamp(System.currentTimeMillis()+ 900000)
            return ps;
        }, keyHolder);
        int quizId = keyHolder.getKey().intValue();
        List<Question> questions = questionDao.getAllQuestionByCategoryId(categoryId);
        Collections.shuffle(questions);
        int i=1;
        for(Question q: questions.subList(0, 10)){
            int qqId = quizQuestionDao.createNewQuizQuestion(quizId, q.getQuestionId(),
                    0, "", i++, false);
        }
        return quizId;
    }
    public int setEndTimeById(int quizId){
        return jdbcTemplate.update("UPDATE Quiz SET end_time=? WHERE quiz_id=?",
                new Timestamp(System.currentTimeMillis()) ,quizId);
    }
    public int deleteQuizById(int id){
        return jdbcTemplate.update("DELETE FROM Quiz WHERE quiz_id=?", id);
    }
}
