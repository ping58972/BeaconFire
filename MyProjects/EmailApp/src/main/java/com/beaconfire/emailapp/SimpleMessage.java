package com.beaconfire.emailapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@JsonDeserialize
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
