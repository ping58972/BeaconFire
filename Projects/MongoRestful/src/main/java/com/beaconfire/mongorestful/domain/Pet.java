package com.beaconfire.mongorestful.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Pet {
    @ApiModelProperty(notes = "Pet name")
    private String name;
    @ApiModelProperty(notes = "Pet species")
    private String species;
}
