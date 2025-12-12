package com.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;

import jakarta.annotation.PostConstruct;

@EnableDiscoveryClient
@SpringBootApplication
@EnableKafka
public class MessagingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingServiceApplication.class, args);
	}
	 @Autowired
	    private Environment env;
	
	@PostConstruct
    public void printConfig() {
        System.out.println("### EFFECTIVE KAFKA BOOTSTRAP = " +
                env.getProperty("spring.kafka.bootstrap-servers"));
    }
}
