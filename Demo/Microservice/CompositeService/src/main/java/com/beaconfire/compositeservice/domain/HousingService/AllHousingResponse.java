package com.beaconfire.compositeservice.domain.HousingService;

import com.beaconfire.compositeservice.entity.HousingService.House;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllHousingResponse {
    private List<House> houseList;
}
