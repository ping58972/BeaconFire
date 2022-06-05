package com.bfs.springdatademo.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Award {
    @ApiModelProperty(notes = "Award name")
    private String name;
    @ApiModelProperty(notes = "Award description")
    private String description;
}
