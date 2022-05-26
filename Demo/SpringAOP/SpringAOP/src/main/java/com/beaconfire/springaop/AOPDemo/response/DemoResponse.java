package com.beaconfire.springaop.AOPDemo.response;

import com.beaconfire.springaop.AOPDemo.domain.Demo;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoResponse {
    private Demo demo;
}
