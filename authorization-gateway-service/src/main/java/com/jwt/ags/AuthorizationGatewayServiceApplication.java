package com.jwt.ags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthorizationGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationGatewayServiceApplication.class, args);
	}

}
