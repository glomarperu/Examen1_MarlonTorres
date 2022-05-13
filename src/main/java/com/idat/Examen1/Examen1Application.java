package com.idat.Examen1;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configurable
@EnableAutoConfiguration
public class Examen1Application {

	public static void main(String[] args) {
		SpringApplication.run(Examen1Application.class, args);
	}

}
