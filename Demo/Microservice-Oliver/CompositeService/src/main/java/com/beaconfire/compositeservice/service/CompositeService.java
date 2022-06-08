package com.beaconfire.compositeservice.service;

import com.beaconfire.compositeservice.domain.HousingService.AllHousingResponse;
import com.beaconfire.compositeservice.domain.HousingUserResponse;
import com.beaconfire.compositeservice.domain.UserService.AllUsersResponse;
import com.beaconfire.compositeservice.service.remote.RemoteHousingService;
import com.beaconfire.compositeservice.service.remote.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompositeService {

    private RemoteHousingService housingService;
    private RemoteUserService userService;
    private RestTemplate restTemplate;

    @Autowired
    public void setHousingService(RemoteHousingService housingService) {
        this.housingService = housingService;
    }

    @Autowired
    public void setUserService(RemoteUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HousingUserResponse getAllHousesAndUsers(){
        return HousingUserResponse.builder()
                .users(userService.getAllUsers().getUsers())
                .houses(housingService.getAllHouses().getHouseList())
                .build();
    }

    public HousingUserResponse getAllHousesAndUsersRest(){
        ResponseEntity<AllHousingResponse> housingResponse = restTemplate.exchange(
                "http://housing-service/housing-service/housing", HttpMethod.GET, null, AllHousingResponse.class
        );

        ResponseEntity<AllUsersResponse> userResponse = restTemplate.exchange(
                "http://user-service/user-service/user", HttpMethod.GET, null, AllUsersResponse.class
        );

        return HousingUserResponse.builder()
                .users(userResponse.getBody().getUsers())
                .houses(housingResponse.getBody().getHouseList())
                .build();
    }


}
