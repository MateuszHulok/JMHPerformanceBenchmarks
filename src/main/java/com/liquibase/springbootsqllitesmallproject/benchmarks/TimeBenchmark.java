package com.liquibase.springbootsqllitesmallproject.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@Measurement(iterations = 1000, time = 10, timeUnit = TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class TimeBenchmark {

    @Benchmark
    public long systemTime() {
        return System.nanoTime();
    }
}