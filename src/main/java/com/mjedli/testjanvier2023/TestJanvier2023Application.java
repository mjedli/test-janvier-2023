package com.mjedli.testjanvier2023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class TestJanvier2023Application {

	public static void main(String[] args) {
		SpringApplication.run(TestJanvier2023Application.class, args);
	}

}
