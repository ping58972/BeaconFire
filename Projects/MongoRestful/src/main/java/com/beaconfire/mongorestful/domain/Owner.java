package com.beaconfire.mongorestful.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "owner")
public class Owner {
    @ApiModelProperty(notes = "Owner id")
    @Id
    @Indexed(unique = true)
    private String id;
    @ApiModelProperty(notes = "Owner name")
    private String name;
    @ApiModelProperty(notes = "List of pets")
    private List<Pet> pets = new ArrayList<>();
}
