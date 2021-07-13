package com.smartmanager.smartmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;


@SpringBootApplication
//@EnableAutoConfiguration(exclude={UserDetailsServiceAutoConfiguration.class})
public class SmartmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartmanagerApplication.class, args);
	}

}
