package com.beaconfire.compositeservice.controller;

import com.beaconfire.compositeservice.domain.HousingService.AllHousingResponse;
import com.beaconfire.compositeservice.domain.HousingUserResponse;
import com.beaconfire.compositeservice.service.CompositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("composite")
public class CompositeController {

    private CompositeService compositeService;

    @Autowired
    public void setCompositeService(CompositeService compositeService) {
        this.compositeService = compositeService;
    }

    @GetMapping
    public HousingUserResponse getHousesAndUser(){
        return compositeService.getAllHousesAndUsers();
    }

    @GetMapping("rest")
    public HousingUserResponse getHousesAndUserRest(){
        return compositeService.getAllHousesAndUsersRest();
    }
}
