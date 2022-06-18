package com.beaconfire.quizonline.dao;

import com.beaconfire.quizonline.dao.jdbc.rowmapper.QuestionRowMapper;
import com.beaconfire.quizonline.dao.jdbc.rowmapper.QuizQuestionRowMapper;
import com.beaconfire.quizonline.dao.jdbc.rowmapper.QuizRowMapper;
import com.beaconfire.quizonline.domain.*;
import com.beaconfire.quizonline.domain.jdbc.CategoryJdbc;
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


public interface QuizDao {

    List<Quiz> getAllQuiz();

    Optional<Quiz> getQuizById(int id);

    List<Quiz> getQuizByUserId(int id);

    List<Quiz> getQuizByCategoryId(int id);

    int createNewQuizByCategoryForUser(int userId, int categoryId);

    int setEndTimeById(int quizId);

    int deleteQuizById(int id);
}
