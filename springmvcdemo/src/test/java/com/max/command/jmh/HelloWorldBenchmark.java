package com.max.command.jmh;

import com.max.HelloService;
import com.max.command.HelloWorldCommand;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/5/2.
 */


@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class HelloWorldBenchmark {

    private HelloService helloService = new HelloService();

    @Benchmark
    public void test() {
        helloService.hello();
    }

    public static void main(String... args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(".*" + HelloWorldBenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .build();
        new Runner(opt).run();


    }

}
