package com.beaconfire.quizrestful.domain;

import com.beaconfire.quizrestful.domain.common.ResponseStatus;
import com.beaconfire.quizrestful.domain.hibernate.QuizHibernate;
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
