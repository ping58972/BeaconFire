package com.bfs.hibernateprojectdemo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Question {
    private Integer id;
    private String description;
    private boolean isActive;
}
