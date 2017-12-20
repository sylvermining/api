package com.juliette.api.shell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.juliette.api")
public class ShellApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShellApplication.class, args);
	}
}
