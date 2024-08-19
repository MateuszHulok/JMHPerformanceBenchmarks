package com.liquibase.springbootsqllitesmallproject.query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class QueryController {

    @Autowired
    private QueryService queryService;


    @GetMapping("/")
    public ResponseEntity<String> random() {
        int nb = new Random().nextInt(10);
        return ResponseEntity.ok(queryService.query(nb).funnyString());
    }
}