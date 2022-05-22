package com.beaconfire.quizonline.dao;

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


public interface QuizQuestionDao {


    List<QuizQuestion> getAllQuizQuestion();

    QuizQuestion getQuizQuestionById(int id);

    QuizQuestion getQuizQuestionByQuizIdAndQuestionId(int quizId, int questId);

    int deleteById(int id);

    int deleteByQuizIdAndQuestionId(int quizId, int questId);

    int createNewQuizQuestion(int quizId, int questId, int userChoiceId,
                              String userShortAnswer, int orderNum, boolean isMarked);

    int updateQuizQuestionById(int qqId, int userChoiceId, String userShortAnswer,
                               int orderNum, boolean isMarked);

    int updateQuizQuestionByQuizIdAndQuestionId(int quizId, int questId, int userChoiceId, String userShortAnswer,
                                                int orderNum, boolean isMarked);
}
