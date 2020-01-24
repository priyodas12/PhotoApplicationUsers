package com.workspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableDiscoveryClient
@SpringBootApplication
public class PhotoApplicationUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoApplicationUsersApplication.class, args);
	}
	
	//adding password encrypter
	@Bean
	public BCryptPasswordEncoder bEncoder() {
		return new BCryptPasswordEncoder();
	}

}
