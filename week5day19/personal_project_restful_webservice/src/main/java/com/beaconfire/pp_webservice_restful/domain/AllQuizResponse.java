package com.beaconfire.pp_webservice_restful.domain;

import com.beaconfire.pp_webservice_restful.domain.Quiz;
import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AllQuizResponse {
    ResponseStatus status;
    List<Quiz> quizzes;
}
