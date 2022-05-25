package service;

import dao.QuizDAO;
import domain.Quiz;

import java.util.List;

public class QuizService {

    @Autowired
    @Qulifier("quizDAOHibernate")
    private QuizDAO quizDAO;

    List<Quiz> getAllQuizzes(){



    }

}
