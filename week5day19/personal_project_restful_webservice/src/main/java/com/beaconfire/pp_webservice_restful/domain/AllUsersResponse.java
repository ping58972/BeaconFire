package com.beaconfire.pp_webservice_restful.domain;

import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
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
