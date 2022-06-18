package com.beaconfire.quizonline.dao;

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


public interface QuestionDao {

    List<Question> getAllQuestion();

    List<Question> getAllQuestionByCategoryId(int id);

    List<Question> getAllQuestionByCategoryIdAndType(int id, String type);

    Optional<Question> getQuestionById(int id);

    int createNewQuestion(int categoryId, String questDesc, String type,
                          String correctAnswer, String... choiceDescrs);

    int changeActiveById(int id);

    int deleteQuestionById(int id);

    int updateQuestion(int questionId, int categoryId, String description, String type,
                       boolean active, int correctAnswerId, String correctAnswer,
                       int choiceId1, String choice1, int choiceId2, String choice2,
                       int choiceId3, String choice3);
}
