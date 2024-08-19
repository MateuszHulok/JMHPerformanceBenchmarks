package com.liquibase.springbootsqllitesmallproject.benchmarks;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, jvmArgsPrepend = { "-XX:+UnlockDiagnosticVMOptions", "-XX:+PrintAssembly", "-Djmh.ignoreLock=true"})
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JitLoopBenchmark {


    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void testMethod(Blackhole blackhole) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0x42;
        }
        blackhole.consume(nums);
    }
}