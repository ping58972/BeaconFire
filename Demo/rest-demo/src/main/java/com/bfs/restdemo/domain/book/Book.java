package com.bfs.restdemo.domain.book;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Book {
    private int isbn;
    private String title;
    private String author;
}



















