package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/7/14.
 */
@SpringBootApplication
@ImportResource(locations={"classpath:spring.xml"})
public class Application {

/*    public static void main(String[] args) {
        Resource resource = new ClassPathResource("spring.xml");
        SpringApplication.run(resource, args);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(9044);
        factory.setSessionTimeout(50, TimeUnit.MINUTES);
        return factory;
    }

    /*@Bean
    public JedisConnectionFactory getJedisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("1");
        jedisConnectionFactory.setPort(1);
        jedisConnectionFactory.setUsePool(false);
        return jedisConnectionFactory;
    }*/
}
