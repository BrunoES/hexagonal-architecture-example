package com.example.hexagonalarchitectureexample.adapter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.hexagonalarchitectureexample.adapter.HexagonalArchitectureExampleApplication;
import com.example.hexagonalarchitectureexample.adapter.outbound.persistence.repository.postgress.PostgressPersonRepository;
import com.example.hexagonalarchitectureexample.service.PersonServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = HexagonalArchitectureExampleApplication.class)
public class BeanConfiguration {

	@Bean
	public PersonServiceImpl personServiceImpl (PostgressPersonRepository repository) {
        return new PersonServiceImpl(repository);
    }
	
}