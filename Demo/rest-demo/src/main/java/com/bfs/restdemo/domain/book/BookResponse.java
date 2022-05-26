package com.bfs.restdemo.domain.book;

import com.bfs.restdemo.domain.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {
    ResponseStatus status;
    Book book;
}
