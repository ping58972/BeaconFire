package com.bfs.springdatademo.repository;

import com.bfs.springdatademo.domain.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageDemoRepo extends PagingAndSortingRepository<City, Integer> {
    // no methods nor fields
}
