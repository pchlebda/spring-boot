package io.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@EnableCircuitBreaker
@SpringBootApplication
public class ClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientDemoApplication.class, args);
	}
}
