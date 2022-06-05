package com.beaconfire.quizrestful.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserQuizzes {
    User user;
    List<Quiz> quizzes;
}
