package com.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = "com.websocket")
@EnableDiscoveryClient
@SpringBootApplication
public class WebsocketGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketGatewayApplication.class, args);
	}

}
