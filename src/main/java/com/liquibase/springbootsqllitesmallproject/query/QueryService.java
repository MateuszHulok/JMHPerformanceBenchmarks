package com.liquibase.springbootsqllitesmallproject.query;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QueryService {

    @Cacheable("query")
    public BigObject query(int nb) {
        log.info("Generating big object - number: {}...", nb);
        return new BigObject(nb);
    }
}