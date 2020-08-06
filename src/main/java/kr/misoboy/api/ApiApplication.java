package kr.misoboy.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "kr.misoboy", exclude = {SecurityAutoConfiguration.class})
public class ApiApplication {

	public static void main(String[] args) {
		System.out.println("Blue/Green Deploy TEST!!");
		SpringApplication.run(ApiApplication.class, args);
	}

}
