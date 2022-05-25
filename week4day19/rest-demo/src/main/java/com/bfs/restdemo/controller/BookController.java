package com.bfs.restdemo.controller;


import com.bfs.restdemo.domain.book.AllBooksResponse;
import com.bfs.restdemo.domain.book.Book;
import com.bfs.restdemo.domain.book.BookResponse;
import com.bfs.restdemo.domain.common.ResponseStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController  // = @Controller + @ResponseBody
@RequestMapping("books")
public class BookController {

    private final List<Book> books;

    public BookController() {
        this.books = new ArrayList<>();
        books.add(Book.builder().isbn(123).title("ABC").author("Alphabet").build());
        books.add(Book.builder().isbn(42).title("Turtles All the Way Down").author("Green").build());
    }

    @GetMapping()
    public AllBooksResponse getAllBooks(){
        return AllBooksResponse.builder()
                .status(
                        ResponseStatus.builder()
                                .success(true)
                                .message("Returning all books")
                                .build()
                )
                .books(books)
                .build();
    }

    @GetMapping("/{isbn}")
    public BookResponse getBookById(@PathVariable Integer isbn) {
        Optional<Book> bookOptional = books.stream()
                .filter(book -> book.getIsbn() == isbn).findFirst();

        if (bookOptional.isPresent()){
            return BookResponse.builder()
                    .status(
                            ResponseStatus.builder()
                                    .success(true)
                                    .message("Success! Book was found")
                                    .build()
                    )
                    .book(bookOptional.get())
                    .build();
        } else {
            return BookResponse.builder()
                    .status(
                            ResponseStatus.builder()
                                    .success(false)
                                    .message("Oops, book not found")
                                    .build()
                    )
                    .build();
        }
    }

    @PostMapping()
    public BookResponse createNewBook(@RequestBody Book book){
        Book newBook = Book.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
        books.add(newBook);

        return BookResponse.builder()
                .status(
                        ResponseStatus.builder()
                                .success(true)
                                .message("New book created")
                                .build()
                )
                .book(newBook)
                .build();
    }
}

