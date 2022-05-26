package com.beaconfire.springaop.AOPDemo.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Demo {
    private Integer id;
    private String type;
    private String description;
}
