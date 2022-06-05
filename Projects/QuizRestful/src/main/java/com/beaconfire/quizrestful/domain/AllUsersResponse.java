package com.beaconfire.quizrestful.domain;

import com.beaconfire.quizrestful.domain.common.ResponseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Builder
public class AllUsersResponse {
    private ResponseStatus status;
    private List<User> users;
}
