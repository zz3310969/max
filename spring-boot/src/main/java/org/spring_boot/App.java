package org.spring_boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SpringApplication.run(App.class, args);
    }
}
