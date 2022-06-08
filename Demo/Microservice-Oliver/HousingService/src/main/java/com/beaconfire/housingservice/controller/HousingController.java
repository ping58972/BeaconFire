package com.beaconfire.housingservice.controller;

import com.beaconfire.housingservice.domain.AllHousingResponse;
import com.beaconfire.housingservice.service.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("housing")
public class HousingController {

    private HousingService housingService;

    @Autowired
    public void setHousingService(HousingService housingService) {
        this.housingService = housingService;
    }

    @GetMapping
    public AllHousingResponse getAllHouses(){
        return AllHousingResponse.builder()
                .houseList(housingService.getAllHouses())
                .build();
    }
}
