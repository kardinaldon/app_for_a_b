package com.ab.app_for_a_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppForABApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppForABApplication.class, args);
	}

}
