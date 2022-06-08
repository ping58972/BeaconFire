package com.beaconfire.compositeservice.service.remote;

import com.beaconfire.compositeservice.domain.UserService.AllUsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("user-service")
public interface RemoteUserService {

    @GetMapping("user-service/user")
    AllUsersResponse getAllUsers();
}
