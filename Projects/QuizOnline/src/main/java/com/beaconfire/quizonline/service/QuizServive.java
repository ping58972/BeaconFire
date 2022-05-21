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
                    Choice choice = q.getChoiceMap().values().stream().findFirst().orElse(new Choice());
                    return choice.getChoiceDesription().equals(qq.getUserShortAnswer()) ? 1 : 0;
                }
                return 0;
            }).reduce(0, (a, b) -> a + b);
            quiz.setScore(score);
            return quiz;
        }).collect(Collectors.toList());
    }

    public Quiz getNewQuiz(int userId, int categoryId) {
        int quizId = quizDao.createNewQuizByCategoryForUser(userId, categoryId);
        return quizDao.getQuizById(quizId).orElse(new Quiz());
    }

    public boolean updateQuizQuestion(QuizQuestion quizQuestion) {
        quizDao.setEndTimeById(quizQuestion.getQuizId());
        return 1 == quizQuestionDao.updateQuizQuestionById(quizQuestion.getQqId(), quizQuestion.getUserChoiceId(),
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
                    Choice choice = q.getChoiceMap().values().stream().findFirst().orElse(new Choice());
                    return choice.getChoiceDesription().equals(qq.getUserShortAnswer()) ? 1 : 0;
                }
                return 0;
            }).reduce(0, (a, b) -> a + b);
            quiz.setScore(score);
            return quiz;
        }).collect(Collectors.toList());

    }

    public List<Question> getAllQuestion() {
        return questionDao.getAllQuestion();
    }

    public boolean createNewQuestion(Question q) {
        return 0 < questionDao.createNewQuestion(q.getCategoryId(), q.getDescription(), q.getType(),
                q.getCorrectAnswer(), q.getChoice1(), q.getChoice2(), q.getChoice3());
    }

    public boolean changeActiveQuestionById(int id) {
        return 1 == questionDao.changeActiveById(id);
    }

    public Question getQuestionById(int id) {
        Question q = questionDao.getQuestionById(id).orElse(new Question());
        Category c = categoryDao.getCategoryById(q.getCategoryId()).orElse(new Category());
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
        return 1 == questionDao.updateQuestion(q.getQuestionId(), q.getCategoryId(),
                q.getDescription(), q.getType(), q.isActive(), q.getCorrectAnswerId(),
                q.getCorrectAnswer(), q.getChoiceId1(), q.getChoice1(), q.getChoiceId2(),
                q.getChoice2(), q.getChoiceId3(), q.getChoice3());
    }
}
