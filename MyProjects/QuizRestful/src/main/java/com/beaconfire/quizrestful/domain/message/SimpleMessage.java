package com.beaconfire.quizrestful.domain.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@Builder
@ToString
public class SimpleMessage implements Serializable {
    private String title;
    private String description;

    public SimpleMessage() {
    }

    public SimpleMessage(@JsonProperty("title") String title,
                         @JsonProperty("description") String description) {
        this.title = title;
        this.description = description;
    }
}
