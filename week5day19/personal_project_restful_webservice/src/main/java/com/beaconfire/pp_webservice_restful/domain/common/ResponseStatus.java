package com.beaconfire.pp_webservice_restful.domain.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class ResponseStatus {
    private boolean success;
    private String message;
}
