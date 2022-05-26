package com.bfs.restdemo.domain.todo;

import lombok.Getter;

@Getter
public class Todo {
    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
}