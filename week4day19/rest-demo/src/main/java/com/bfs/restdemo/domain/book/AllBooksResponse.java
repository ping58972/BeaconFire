package com.bfs.restdemo.domain.book;

import com.bfs.restdemo.domain.common.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AllBooksResponse {
    private ResponseStatus status;
    private List<Book> books;
}
