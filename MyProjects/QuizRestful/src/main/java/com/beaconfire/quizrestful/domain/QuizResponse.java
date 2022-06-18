package com.beaconfire.quizrestful.domain;

import com.beaconfire.quizrestful.domain.common.ResponseStatus;
import com.beaconfire.quizrestful.domain.hibernate.QuizHibernate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuizResponse {
    ResponseStatus status;
    Quiz quiz;
}
