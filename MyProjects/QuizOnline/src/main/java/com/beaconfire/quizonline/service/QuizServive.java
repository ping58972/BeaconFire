package com.beaconfire.quizonline.service;

import com.beaconfire.quizonline.dao.CategoryDao;
import com.beaconfire.quizonline.dao.QuestionDao;
import com.beaconfire.quizonline.dao.QuizDao;
import com.beaconfire.quizonline.dao.QuizQuestionDao;
import com.beaconfire.quizonline.domain.*;
import com.beaconfire.quizonline.domain.jdbc.CategoryJdbc;
import com.beaconfire.quizonline.domain.jdbc.ChoiceJdbc;
import com.beaconfire.quizonline.domain.jdbc.QuestionJdbc;
import com.beaconfire.quizonline.domain.jdbc.QuizJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizServive {
    CategoryDao categoryDaoJdbc;
    CategoryDao categoryDaoHibernate;
    QuestionDao questionDaoJdbc;
    QuestionDao questionDaoHibernate;
    QuizDao quizDaoJdbc;
    QuizDao quizDaoHibernate;
    QuizQuestionDao quizQuestionDaoJdbc;
    QuizQuestionDao quizQuestionDaoHibernate;

    @Autowired
    @Qualifier("categoryDaoJdbcImpl")
    public void setCategoryDaoJdbc(CategoryDao categoryDaoJdbc) {
        this.categoryDaoJdbc = categoryDaoJdbc;
    }

    @Autowired
    @Qualifier("categoryDaoHibernateImpl")
    public void setCategoryDaoHibernate(CategoryDao categoryDaoHibernate) {
        this.categoryDaoHibernate = categoryDaoHibernate;
    }

    @Autowired
    @Qualifier("questionDaoJdbcImpl")
    public void setQuestionDaoJdbc(QuestionDao questionDaoJdbc) {
        this.questionDaoJdbc = questionDaoJdbc;
    }

    @Autowired
    @Qualifier("questionDaoHibernateImpl")
    public void setQuestionDaoHibernate(QuestionDao questionDaoHibernate) {
        this.questionDaoHibernate = questionDaoHibernate;
    }

    @Autowired
    @Qualifier("quizDaoJdbcImpl")
    public void setQuizDaoJdbc(QuizDao quizDaoJdbc) {
        this.quizDaoJdbc = quizDaoJdbc;
    }

    @Autowired
    @Qualifier("quizDaoHibernateImpl")
    public void setQuizDaoHibernate(QuizDao quizDaoHibernate) {
        this.quizDaoHibernate = quizDaoHibernate;
    }

    @Autowired
    @Qualifier("quizQuestionDaoJdbcImpl")
    public void setQuizQuestionDaoJdbc(QuizQuestionDao quizQuestionDaoJdbc) {
        this.quizQuestionDaoJdbc = quizQuestionDaoJdbc;
    }

    @Autowired
    @Qualifier("quizQuestionDaoHibernateImpl")
    public void setQuizQuestionDaoHibernate(QuizQuestionDao quizQuestionDaoHibernate) {
        this.quizQuestionDaoHibernate = quizQuestionDaoHibernate;
    }

    public List<Category> getAllCategory() {
        return categoryDaoJdbc.getAllCategory();
    }

    public List<Quiz> getAllQuizByUser(int id) {
        return quizDaoJdbc.getQuizByUserId(id).stream().map(quiz -> {
            int score = quiz.getQuizQuestionMap().values().stream().map(qq -> {
                Question q = qq.getQuestion();
                if (q.getType().equals("MULTIPLE_CHOICE")) {
                    Choice choice = q.getChoiceMap().get(qq.getUserChoiceId());
                    if (choice == null) {
                        qq.setCorrect(false);
                        qq.setMessage("The Answer was not Selected!");
                        return 0;
                    }
                    if (choice.isCorrect()) {
                        qq.setCorrect(true);
                        qq.setMessage("Got Correct Answer!");
                        return 1;
                    }
                    qq.setCorrect(false);
                    qq.setMessage("Got Wrong Answer!");
                    return 0;
                } else if (q.getType().equals("SHORT_ANSWER")) {
                    Choice choice = q.getChoiceMap().values().stream().findFirst().orElse(new ChoiceJdbc());
                    return choice.getChoiceDesription().equals(qq.getUserShortAnswer()) ? 1 : 0;
                }
                return 0;
            }).reduce(0, (a, b) -> a + b);
            quiz.setScore(score);
            return quiz;
        }).collect(Collectors.toList());
    }

    public Quiz getNewQuiz(int userId, int categoryId) {
        int quizId = quizDaoJdbc.createNewQuizByCategoryForUser(userId, categoryId);
        return quizDaoJdbc.getQuizById(quizId).orElse(new QuizJdbc());
    }

    public boolean updateQuizQuestion(QuizQuestion quizQuestion) {
        quizDaoJdbc.setEndTimeById(quizQuestion.getQuizId());
        return 1 == quizQuestionDaoJdbc.updateQuizQuestionById(quizQuestion.getQqId(), quizQuestion.getUserChoiceId(),
                quizQuestion.getUserShortAnswer(), quizQuestion.getOrderNum(), quizQuestion.isMarked());
    }

    public Quiz getQuizById(Integer quizId) {
        return quizDaoJdbc.getQuizById(quizId).orElse(new QuizJdbc());
    }

    public void setEndTimeById(Integer quizId) {
        quizDaoJdbc.setEndTimeById(quizId);
    }

    public List<Quiz> getAllQuiz() {
        return quizDaoJdbc.getAllQuiz().stream().map(quiz -> {
            int score = quiz.getQuizQuestionMap().values().stream().map(qq -> {
                Question q = qq.getQuestion();
                if (q.getType().equals("MULTIPLE_CHOICE")) {
                    Choice choice = q.getChoiceMap().get(qq.getUserChoiceId());
                    if (choice == null) {
                        qq.setCorrect(false);
                        qq.setMessage("The Answer was not Selected!");
                        return 0;
                    }
                    if (choice.isCorrect()) {
                        qq.setCorrect(true);
                        qq.setMessage("Got Correct Answer!");
                        return 1;
                    }
                    qq.setCorrect(false);
                    qq.setMessage("Got Wrong Answer!");
                    return 0;
//                    return choice.isCorrect() ? 1 : 0;
                } else if (q.getType().equals("SHORT_ANSWER")) {
                    Choice choice = q.getChoiceMap().values().stream().findFirst().orElse(new ChoiceJdbc());
                    return choice.getChoiceDesription().equals(qq.getUserShortAnswer()) ? 1 : 0;
                }
                return 0;
            }).reduce(0, (a, b) -> a + b);
            quiz.setScore(score);
            return quiz;
        }).collect(Collectors.toList());

    }

    public List<Question> getAllQuestion() {
        return questionDaoJdbc.getAllQuestion();
    }

    public boolean createNewQuestion(Question q) {
        return 0 < questionDaoJdbc.createNewQuestion(q.getCategoryId(), q.getDescription(), q.getType(),
                q.getCorrectAnswer(), q.getChoice1(), q.getChoice2(), q.getChoice3());
    }

    public boolean changeActiveQuestionById(int id) {
        return 1 == questionDaoJdbc.changeActiveById(id);
    }

    public Question getQuestionById(int id) {
        Question q = questionDaoJdbc.getQuestionById(id).orElse(new QuestionJdbc());
        Category c = categoryDaoJdbc.getCategoryById(q.getCategoryId()).orElse(new CategoryJdbc());
        q.setCategoryName(c.getName());
        Map<Integer, Choice> mapChoice = q.getChoiceMap();
        List<Choice> choices = new ArrayList<>();
        q.setQuestionId(id);
        for (Map.Entry<Integer, Choice> entry : mapChoice.entrySet()) {
            if (entry.getValue().isCorrect()) {
                q.setCorrectAnswerId(entry.getValue().getChoiceId());
                q.setCorrectAnswer(entry.getValue().getChoiceDesription());
            } else {
                choices.add(entry.getValue());
            }
        }
        if (q.getType().equals("MULTIPLE_CHOICE")) {
            q.setChoice1(choices.get(0).getChoiceDesription());
            q.setChoiceId1(choices.get(0).getChoiceId());
            q.setChoice2(choices.get(1).getChoiceDesription());
            q.setChoiceId2(choices.get(1).getChoiceId());
            q.setChoice3(choices.get(2).getChoiceDesription());
            q.setChoiceId3(choices.get(2).getChoiceId());
        }

        return q;
    }

    public boolean updateQuestion(Question q) {
        return 1 == questionDaoJdbc.updateQuestion(q.getQuestionId(), q.getCategoryId(),
                q.getDescription(), q.getType(), q.isActive(), q.getCorrectAnswerId(),
                q.getCorrectAnswer(), q.getChoiceId1(), q.getChoice1(), q.getChoiceId2(),
                q.getChoice2(), q.getChoiceId3(), q.getChoice3());
    }
}
