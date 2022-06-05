package com.beaconfire.quizrestful.dao;

import com.beaconfire.quizrestful.exception.QuestionNotFoundException;

import java.util.List;

public interface QuestionDao {
    List<Object> getQuestionByQuizId(int id) throws QuestionNotFoundException;
}
