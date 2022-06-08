package com.bfs.bookstore.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

//public class MovieClientFallbackFactory{
//
//}
//

@Component
public class MovieClientFallbackFactory implements FallbackFactory<MovieClient> {

    @Override
    public MovieClient create(Throwable throwable) {
        return new MovieClientFallback(throwable);
    }
}
