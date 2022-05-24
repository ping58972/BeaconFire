package com.beaconfire.pp_webservice_restful.domain;

import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
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
