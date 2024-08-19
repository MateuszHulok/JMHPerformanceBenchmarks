package com.liquibase.springbootsqllitesmallproject.benchmarks;


import org.openjdk.jmh.annotations.*;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringConcatBenchmarks {

    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 10, time = 1)
    @Warmup(iterations = 5, time = 1)
    public String stringContent() {
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result += String.valueOf(i);
        }
        return result;
    }

    public String contactUsingStringBuilder() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            result.append(i);
        }
        return result.toString();
    }


    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 10, time = 1)
    @Warmup(iterations = 5, time = 1)
    public String contactUsingStream() {
        return IntStream.range(0, 1000)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}