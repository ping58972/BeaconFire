package com.beaconfire.housingservice.service;

import com.beaconfire.housingservice.dao.HousingDAO;
import com.beaconfire.housingservice.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousingService {

    private HousingDAO housingDAO;

    @Autowired
    public void setHousingDAO(HousingDAO housingDAO) {
        this.housingDAO = housingDAO;
    }

    public List<House> getAllHouses(){
        return housingDAO.getAllHouses();
    }
}
