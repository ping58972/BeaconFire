package com.beaconfire.quizonline.service;

import com.beaconfire.quizonline.dao.CategoryDao;
import com.beaconfire.quizonline.dao.QuestionDao;
import com.beaconfire.quizonline.dao.QuizDao;
import com.beaconfire.quizonline.dao.QuizQuestionDao;
import com.beaconfire.quizonline.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizServive {
    CategoryDao categoryDao;
    QuestionDao questionDao;
    QuizDao quizDao;
    QuizQuestionDao quizQuestionDao;

    public QuizServive(CategoryDao categoryDao, QuestionDao questionDao, QuizDao quizDao, QuizQuestionDao quizQuestionDao) {
        this.categoryDao = categoryDao;
        this.questionDao = questionDao;
        this.quizDao = quizDao;
        this.quizQuestionDao = quizQuestionDao;
    }

    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    public List<Quiz> getAllQuizByUser(int id) {

        return quizDao.getQuizByUserId(id).stream().map(quiz -> {
            int score = quiz.getQuizQuestionMap().values().stream().map(qq -> {
                Question q = qq.getQuestion();
                if (q.getType().equals("MULTIPLE_CHOICE")) {
                    Choice choice = q.getChoiceMap().get(qq.getUserChoiceId());
                    return choice.isCorrect() ? 1 : 0;
                } else if (q.getType().equals("SHORT_ANSWER")) {
                    Choice choice = q.getChoiceMap().values().stream().findFirst().orElse(new Choice());
                    return choice.getChoiceDesription().equals(qq.getUserShortAnswer()) ? 1 : 0;
                }
                return 0;
            }).reduce(1, (a, b) -> a + b);
            quiz.setScore(score);
            return quiz;
        }).collect(Collectors.toList());
    }

    public Quiz getNewQuiz(int userId, int categoryId) {
        int quizId = quizDao.createNewQuizByCategoryForUser(userId, categoryId);
        return quizDao.getQuizById(quizId).orElse(new Quiz());
    }

    public void updateQuizQuestion(QuizQuestion quizQuestion) {
        quizQuestionDao.updateQuizQuestionById(quizQuestion.getQqId(), quizQuestion.getUserChoiceId(),
                quizQuestion.getUserShortAnswer(), quizQuestion.getOrderNum(), quizQuestion.isMarked());
    }

    public Quiz getQuizById(Integer quizId) {
        return quizDao.getQuizById(quizId).orElse(new Quiz());
    }

    public void setEndTimeById(Integer quizId) {
        quizDao.setEndTimeById(quizId);
    }

    public List<Quiz> getAllQuiz() {
        return quizDao.getAllQuiz().stream().map(quiz -> {
            int score = quiz.getQuizQuestionMap().values().stream().map(qq -> {
                Question q = qq.getQuestion();
                if (q.getType().equals("MULTIPLE_CHOICE")) {
                    Choice choice = q.getChoiceMap().get(qq.getUserChoiceId());
                    return choice.isCorrect() ? 1 : 0;
                } else if (q.getType().equals("SHORT_ANSWER")) {
                    Choice choice = q.getChoiceMap().values().stream().findFirst().orElse(new Choice());
                    return choice.getChoiceDesription().equals(qq.getUserShortAnswer()) ? 1 : 0;
                }
                return 0;
            }).reduce(1, (a, b) -> a + b);
            quiz.setScore(score);
            return quiz;
        }).collect(Collectors.toList());

    }
}
