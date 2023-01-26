package com.example.hexagonalarchitectureexample.adapter.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.hexagonalarchitectureexample.adapter.HexagonalArchitectureExampleApplication;
import com.example.hexagonalarchitectureexample.adapter.inbound.dto.PersonDTO;
import com.example.hexagonalarchitectureexample.adapter.outbound.persistence.repository.postgress.PostgressPersonRepository;
import com.example.hexagonalarchitectureexample.port.KafkaProducerServicePort;
import com.example.hexagonalarchitectureexample.service.PersonServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = HexagonalArchitectureExampleApplication.class)
public class BeanConfiguration {

	@Value("${kafka.address:localhost:9092}")
	private String kafkaAddress;
	
	@Bean
	public PersonServiceImpl personServiceImpl (PostgressPersonRepository repository, KafkaProducerServicePort<PersonDTO> kafkaProducerServicePort) {
        return new PersonServiceImpl(repository, kafkaProducerServicePort);
    }
	
	
}