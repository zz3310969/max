package com.max.command.jmh;

import com.max.BaiduService;
import com.max.HelloService;
import com.max.command.BaiduCommand;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
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
public class BaiduBenchmark {

    private BaiduService baiduService = new BaiduService();

    @Benchmark
    public void test() throws IOException {
        baiduService.http();
    }

    @Benchmark
    public void commandTest() throws IOException {
        BaiduCommand baiduCommand = new BaiduCommand(baiduService);
        baiduCommand.execute();
    }

    public static void main(String... args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(".*" + BaiduBenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .build();
        new Runner(opt).run();


    }

}
