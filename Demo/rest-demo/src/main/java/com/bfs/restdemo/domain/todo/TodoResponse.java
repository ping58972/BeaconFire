package com.bfs.restdemo.domain.todo;

import com.bfs.restdemo.domain.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoResponse {
    private ResponseStatus status;
    private Todo todo;
}
