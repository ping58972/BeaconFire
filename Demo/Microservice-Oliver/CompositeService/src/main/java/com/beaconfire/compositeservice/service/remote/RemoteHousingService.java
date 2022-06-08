package com.beaconfire.compositeservice.service.remote;

import com.beaconfire.compositeservice.domain.HousingService.AllHousingResponse;
import com.beaconfire.compositeservice.entity.HousingService.House;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("housing-service")
public interface RemoteHousingService {

    @GetMapping("housing-service/housing")
    AllHousingResponse getAllHouses();
}
