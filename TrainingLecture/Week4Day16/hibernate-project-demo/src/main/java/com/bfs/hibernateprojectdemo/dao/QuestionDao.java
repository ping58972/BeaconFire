package com.bfs.hibernateprojectdemo.dao;

import com.bfs.hibernateprojectdemo.domain.Question;

import java.util.List;

public interface QuestionDao {
    Question getQuestionById(int id);
    List<Question> getAllQuestions();
    void addQuestion(Question question);
}
