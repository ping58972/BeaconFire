package com.beaconfire.quizrestful.domain;

import com.beaconfire.quizrestful.domain.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserQuizzesResponse {
    ResponseStatus status;
    UserQuizzes userQuizzes;
}
