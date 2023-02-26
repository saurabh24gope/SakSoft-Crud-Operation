package com.shaksoft.crudoperation;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class CrudOperationApplication extends SpringServletContainerInitializer {

	public static void main(String[] args) {

		SpringApplication.run(CrudOperationApplication.class, args);
	}
    @Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
