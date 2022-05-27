package com.beaconfire.pp_webservice_restful.dao;

import com.beaconfire.pp_webservice_restful.domain.*;
import com.beaconfire.pp_webservice_restful.exception.QuizNotFoundException;

import java.util.List;

public interface QuizDao {

    List<Quiz> getAllQuizzes() throws QuizNotFoundException;
    List<Quiz>  getAllQuizzesByUserId(int userId) throws QuizNotFoundException;
}
