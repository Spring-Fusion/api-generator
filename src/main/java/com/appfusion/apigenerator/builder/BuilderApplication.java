package com.appfusion.apigenerator.builder;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.appfusion.apigenerator.builder.resourceLoader.StartRunner;

@SpringBootApplication
public class BuilderApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(BuilderApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		new StartRunner().run(args);
	}
 
}
