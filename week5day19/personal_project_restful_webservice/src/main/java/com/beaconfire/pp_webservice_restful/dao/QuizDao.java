package com.beaconfire.pp_webservice_restful.dao;

import com.beaconfire.pp_webservice_restful.domain.*;

import java.util.List;

public interface QuizDao {

    List<Quiz> getAllQuizzes();
    List<Quiz>  getAllQuizzesByUserId(int userId);
}
