package com.max.command.jmh;

import com.max.HelloService;
import com.max.command.HelloWorldCommand;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Created by lenovo on 2017/5/2.
 */
public class HelloWorldCommandBenchmark {

    private HelloService helloService = new HelloService();

    @Benchmark
    public void test(){
        for (int i = 0;i<1000;i++){
            HelloWorldCommand command = new HelloWorldCommand(helloService);
            command.execute();
        }
    }

    public static void main(String... args) throws RunnerException {


    }

}
