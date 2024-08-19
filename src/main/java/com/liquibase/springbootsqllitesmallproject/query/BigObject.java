package com.liquibase.springbootsqllitesmallproject.query;

import java.io.Serializable;
import java.util.Random;

public class BigObject implements Serializable {

    private static final long serialVersionUID = 1L;

    public byte[] largeArray = new byte[10 * 1024 * 1024];
    public int nb;

    public BigObject(int nb) {
        this.nb = nb;
        new Random().nextBytes(largeArray);
    }


    public String funnyString() {
        try {
            Thread.sleep(70);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return "ha ha ha - byte[0]=" + largeArray[0];
    }
}