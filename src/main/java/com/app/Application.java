package com.app;

import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.repository")
@EntityScan("com.model")
public class Application  extends FatJarRouter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    @Override
    public void configure() throws Exception {
        from("netty-http:http://0.0.0.0:18080").
                setBody().simple("ref:helloWorld");
    }

    @Bean
    String helloWorld() {
        return "helloWorld";
    }


}
